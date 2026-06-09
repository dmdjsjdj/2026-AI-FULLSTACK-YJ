package com.the703.dao;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

@Mapper
public interface UserMapper {
	public int insert(UserDto dto);
    public int findLogin(UserDto dto);
    public UserDto findByUno(int uno);
    public String  findByEmail(String email);
    
	/* security */
    public int insertAuth(AuthDto dto);
    public AuthListDto readAuth(AuthDto dto);
}
/*
#2)  2) Dao - UserMapper   user-mapper.xml
         join / login / mypage  / 아이디 중복검사 (해당 sql 찾기)

    create  :
        INSERT INTO users (nickname , bpass, email , mobile, bip) 
        VALUES (#{nickname }, #{bpass}, #{email}, #{mobile}, #{bip});

    read  :
        select count(*) from users where email=#{email} and bpass=#{bpass};
        select       *  from users where uno=#{uno}
        select email    from users where email=#{email}
*/

/*
    mysql> desc authorities;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| email | varchar(50) | NO   |     | NULL    |       |
| auth  | varchar(50) | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql>

1) insert 구문찾기 aaa@gmail.com / ROLE_MEMBER
   insert into authorities (email, auth) values ( #{email}, #{auth})

2) join 이용해서   aaa@gmail.com의 
    email, bpass, auth 필드값찾기
  select u.email, u.bpass, a.auth
  from users u left join authorities a on u.email = a.email
  where u.email=#{email}
*/