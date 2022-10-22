package rs.ac.metropolitan.rentparking_mapbox.service;

import retrofit2.Call;
import retrofit2.http.GET;
import rs.ac.metropolitan.rentparking_mapbox.entity.*;


import java.util.List;

public interface UserService {
    @GET("users")
    Call<List<User>> findAll();

    User save(User user);

//	User saveSocialUser(SocialUser socialUser);

    User update(User user);

    User findById(Integer userId);

    User findByUsername(String username);

    void deleteById(Integer userId);

    List<Role> findAllRolesById(Integer userId);

    List<Role> addRolesById(Integer userId, List<Role> roles);

    List<Role> setRolesById(Integer userId, List<Role> roles);

    List<Role> deleteRolesById(Integer userId, List<Role> roles);

}