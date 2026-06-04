package com.the703.dto;

import lombok.Data;

@Data
public class BoardDto {
	//bname, bpass, btitle, bcontent, bdate, bhit, bip
	private int bno;
	private String bname;
	private String bpass;
	private String btitle;
	private String bcontent;
	private String bdate;
	private String bhit;
	private String bip;
}

/*
mysql> desc mvcboard2;
+----------+--------------+------+-----+-------------------+-------------------+
| Field    | Type         | Null | Key | Default           | Extra             |
+----------+--------------+------+-----+-------------------+-------------------+
| bno      | int          | NO   | PRI | NULL              | auto_increment    |
| bname    | varchar(200) | NO   |     | NULL              |                   |
| bpass    | varchar(50)  | NO   |     | NULL              |                   |
| btitle   | varchar(100) | NO   |     | NULL              |                   |
| bcontent | text         | NO   |     | NULL              |                   |
| bdate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bhit     | int          | NO   |     | 0                 |                   |
| bip      | varchar(50)  | NO   |     | NULL              |                   |
+----------+--------------+------+-----+-------------------+-------------------+
8 rows in set (0.00 sec)
*/