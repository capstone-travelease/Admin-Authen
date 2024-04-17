package com.capstone.AdminAuthen.Repository;

import com.capstone.AdminAuthen.DTO.UserLoginDTO;
import com.capstone.AdminAuthen.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
  @Query("Select u from Users u WHERE u.email = ?1 ")
  Optional<Users> findByEmail(String email);

  @Query(value = "Select new com.capstone.AdminAuthen.DTO.UserLoginDTO(u.user_id, u.email, u.full_name,u.password, u.role_id) from Users u WHERE u.email = ?1 AND u.role_id = ?2")
  UserLoginDTO generateUser(String email, Integer roleId);

  @Query(value = "Select u.email from Users u where u.email = ?1")
  String findEmail(String email);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO public.users(\n" +
          "\tgender, role_id, email, full_name, password, phone_number, dob)\n" +
          "\tVALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)",nativeQuery = true)
  void addUser(boolean gender, Integer roleId, String email, String fullName, String password, String phoneNumber, Date dob);
}
