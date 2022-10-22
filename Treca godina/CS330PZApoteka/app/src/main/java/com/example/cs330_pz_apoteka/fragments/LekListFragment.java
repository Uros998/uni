package com.example.cs330_pz_apoteka.fragments;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.cs330_pz_apoteka.ListAdapter;
import com.example.cs330_pz_apoteka.R;
import com.example.cs330_pz_apoteka.entities.Lek;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class LekListFragment extends AppCompatActivity {
    ListView listView;
    ArrayList<Lek> list;
    ListAdapter adapter = null;

    ImageView imageViewIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lekovi_list);

        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new ListAdapter(this, R.layout.lek_red, list);
        listView.setAdapter(adapter);

        Cursor cursor = LekFragment.DBHelper.getData("SELECT * FROM lek");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String naziv = cursor.getString(1);
            String tip = cursor.getString(2);
            String opis = cursor.getString(3);
            int cena= cursor.getInt(4);
            byte[] img  = cursor.getBlob(5);
            list.add(new Lek(id, naziv, tip, opis, cena, img));
        }
        adapter.notifyDataSetChanged();
        if (list.size()==0){
            Toast.makeText(this, "Nema lekova", Toast.LENGTH_SHORT).show();
        }

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                final CharSequence[] items = {"Update", "Obrisi"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(LekListFragment.this);

                dialog.setTitle("Opcija");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 0){
                            //update
                            Cursor c = LekFragment.DBHelper.getData("SELECT lek_id FROM lek");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            //show update dialog
                            showDialogUpdate(LekListFragment.this, arrID.get(position));
                        }
                        if (i==1){
                            //delete
                            Cursor c = LekFragment.DBHelper.getData("SELECT lek_id FROM lek");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }

    private void showDialogDelete(final int lekId) {
        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(this);
        dialogDelete.setTitle("Upozorenje!!");
        dialogDelete.setMessage("Da li ste sigurni da zelite obrisati?");
        dialogDelete.setPositiveButton("Da", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    LekFragment.DBHelper.deleteLek(lekId);
                    Toast.makeText(LekListFragment.this, "Izbrisano uspesno", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Log.e("error", e.getMessage());
                }
                updateMovieList();
            }
        });
        dialogDelete.setNegativeButton("Ne", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void showDialogUpdate(LekListFragment activity, final int position){
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.lek_update);
        dialog.setTitle("Update");

        imageViewIcon = dialog.findViewById(R.id.edtImg);
        final EditText edtName = dialog.findViewById(R.id.edtName);
        final EditText edtGenre = dialog.findViewById(R.id.edtGenre);
        final EditText edtDescription = dialog.findViewById(R.id.edtDescription);
        final EditText edtRating = dialog.findViewById(R.id.edtRating);
        Button btnUpdate = dialog.findViewById(R.id.btnUpdate);

        int width = (int)(activity.getResources().getDisplayMetrics().widthPixels*0.95);
        int height = (int)(activity.getResources().getDisplayMetrics().heightPixels*0.7);
        dialog.getWindow().setLayout(width,height);
        dialog.show();

        imageViewIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        LekListFragment.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888
                );
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    LekFragment.DBHelper.updateLek(
                            position,
                            edtName.getText().toString().trim(),
                            edtGenre.getText().toString().trim(),
                            edtDescription.getText().toString().trim(),
                            Integer.parseInt(edtRating.getText().toString()),
                            LekFragment.imageViewToByte(imageViewIcon)
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Update Successfull", Toast.LENGTH_SHORT).show();
                }
                catch (Exception error){
                    Log.e("Update error", error.getMessage());
                }
                updateMovieList();
            }
        });

    }

    private void updateMovieList() {
        Cursor cursor = LekFragment.DBHelper.getData("SELECT * FROM lek");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String naziv = cursor.getString(1);
            String tip = cursor.getString(2);
            String opis = cursor.getString(3);
            int cena = cursor.getInt(4);
            byte[] img  = cursor.getBlob(5);
            list.add(new Lek(id, naziv, tip, opis, cena, img));
        }
        adapter.notifyDataSetChanged();
    }


    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 888){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //gallery intent
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, 888);
            }
            else {
                Toast.makeText(getApplicationContext(), "Don't have permission to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 888 && resultCode == RESULT_OK){
            Uri imageUri = data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON) //enable image guidlines
                    .setAspectRatio(1,1)// image will be square
                    .start(LekListFragment.this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result =CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK){
                Uri resultUri = result.getUri();
                imageViewIcon.setImageURI(resultUri);
            }
            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
