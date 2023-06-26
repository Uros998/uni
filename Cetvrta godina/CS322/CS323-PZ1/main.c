#include <stdio.h>
#include <conio.h>

void addstudent();
void studentrecord();
void searchstudent();
void delete();

struct student{
    char first_name[20];
    char last_name[20];
    int roll_no;
    char Class[10];
    char vill[20];
    float per;
};

void main() {
    int choice;
    while(choice!=5) {
        printf("=======EVIDENCIJA STUDENTA=======");
        printf("\n\n 1. Dodaj novog studenta\n");
        printf(" 2. Prikaz svih studenta\n");
        printf(" 3. Pretrazi studenta\n");
        printf(" 4. Obrisi studenta\n");
        printf(" 5. Izadji\n");
        printf("______________________________________________________________________________\n");
        scanf("%d", &choice);


        switch(choice){
            case 1:
                addstudent();
                break;
            case 2:

                studentrecord();
                printf("  Pretisini bilo koje dugme za izlaz..... \n");
                getch();

                break;

            case 3:

                searchstudent();
                printf("\n  Pretisini bilo koje dugme za izlaz.......\n");

                getch();
                break;

            case 4:

                delete();
                printf("\n Pretisini bilo koje dugme za izlaz.......\n");
                getch();

                break;
            case 5:

                printf("\n Hvala, sto ste koristili nas softver.\n\n");
                break;

            default :

                getch();
                printf("\nUnesite validan broj\n\n");
                printf("Pretisni bilo koje dugme za nastavak.......");
                getch();

                break;
        }

    }

    getch();
}

void addstudent(){

    char another;
    FILE *fp;
    int n,i;
    struct student info;
    do{

        printf("=======Dodaj studenta=======\n\n");
        fp=fopen("information.txt","a"); //use can give any file name. Give the name with extention or without extention.

        printf("\nUnesite ime               : ");
        scanf("%s",&info.first_name);
        printf("\nUnesite prezime           : ");
        scanf("%s",&info.last_name);
        printf("\nUnesite id                : ");
        scanf("%d",&info.roll_no);
        printf("\nUnesite godinu studiranja : ");
        scanf("%s",&info.Class);
        printf("\nUnesite adresu            : ");
        scanf("%s",&info.vill);
        printf("\nUnesite prosek            : ");
        scanf("%f",&info.per);
        printf("\n______________________________\n");

        if(fp==NULL){
            fprintf(stderr,"ne mogu otvoriti fajl");
        }else{
            printf("Student je uspesno sacuvan\n");
        }

        fwrite(&info, sizeof(struct student), 1, fp);
        fclose(fp);

        printf("Da li zelite dodati jos jednog studenta?(y/n) : ");
        scanf("%s",&another);


    }while(another=='y'||another=='Y');
}

void studentrecord(){

    FILE *fp;

    struct student info;
    fp=fopen("information.txt","r");

    if(fp==NULL){

        fprintf(stderr,"ne mogu otvoriti fajl\n");

    }else{
        printf("Lista studenta :\n");
        printf("___________\n\n");
    }

    while(fread(&info,sizeof(struct student),1,fp)){
        printf("\n Student              : %s %s",info.first_name,info.last_name);
        printf("\n Id studenta          : %d",info.roll_no);
        printf("\n Godina studiranja    : %s",info.Class);
        printf("\n Adresa studenta      : %s",info.vill);
        printf("\n Prosek studenta      : %f%",info.per);
        printf("\n ________________________________\n");

    }
    fclose(fp);
    getch();

}

void searchstudent(){
    struct student info;
    FILE *fp;
    int roll_no,found=0;

    fp=fopen("information.txt","r");
    printf("=======Pretrazi studenta=======\n\n\n");
    printf("Unesite id studenta : ");

    scanf("%d",&roll_no);



    while(fread(&info,sizeof(struct student),1,fp)>0){

        if(info.roll_no==roll_no){

            found=1;
            printf("\n\nStudent         : %s %s",info.first_name,info.last_name);
            printf("\nId studenta       : %d",info.roll_no);
            printf("\nGodina studiranja : %s",info.Class);
            printf("\nAdresa studenta   : %s",info.vill);
            printf("\nProsek studenta   : %f%",info.per);
            printf("\n______________________________________\n");

        }

    }

    if(!found){
        printf("\nStudent nije pronadjen\n");
    }

    fclose(fp);
    getch();

}


void delete(){
    struct student info;
    FILE *fp, *fp1;


    int roll_no,found=0;

    printf("=======Obrisi studenta=======\n\n\n");
    fp=fopen("information.txt","r");
    fp1=fopen("temp.txt","w");
    printf("Unesite id studenta : ");
    scanf("%d",&roll_no);
    if(fp==NULL){
        fprintf(stderr,"ne mogu otvoriti fajl\n");

    }

    while(fread(&info,sizeof(struct student),1,fp)){
        if(info.roll_no == roll_no){

            found=1;

        }else{
            fwrite(&info,sizeof(struct student),1,fp1);
        }

    }
    fclose(fp);
    fclose(fp1);

    if(!found){
        printf("\nStudent nije pronadjen\n");
    }
    if(found){
        remove("information.txt");
        rename("temp.txt","information.txt");

        printf("\nUspesno ste obrisali studenta\n");
    }

    getch();
}