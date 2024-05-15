package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.LoginBean;

import java.io.*;

public class LoginDAOCSV {

    private static final int EMAIL_POSITION=0;
    private static final int PASSWORD_POSITION=1;
    private static final String CSV_LOGIN_NAME = "src/main/res/Login.csv";
    private static final String CSV_USER_NAME = "src/main/res/User.csv";
    private static final String CSV_LIBRARY_NAME = "src/main/res/Library.csv";


    public static int checkLogin(LoginBean loginBean)
    {

         int x=0;
         boolean flag=false;
         try {
             File file = new File(CSV_LOGIN_NAME);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             String row;
             String[] data;

             while ((row = bufferedReader.readLine()) != null) {
                 data = row.split(",");
                 if (data[EMAIL_POSITION].equals(loginBean.getEmail())) {
                     if (data[PASSWORD_POSITION].equals(loginBean.getPassword())) {
                         flag = true;
                     }
                 }
             }
             bufferedReader.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

         if(flag) {
             x=Math.max(foundUserType(loginBean), foundLibraryType(loginBean));
         }

         return x;
    }

    private static int foundUserType(LoginBean loginBean)
    {
        File file = new File(CSV_USER_NAME);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String row;
        String[] data;
        while ((row = bufferedReader.readLine()) != null) {
            data = row.split(",");
            if (data[EMAIL_POSITION].equals(loginBean.getEmail()))
                    return 1;
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    private static int foundLibraryType(LoginBean loginBean)
    {
        File file = new File(CSV_LIBRARY_NAME);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String row;
            String[] data;
            while ((row = bufferedReader.readLine()) != null) {
                data = row.split(",");
                if (data[EMAIL_POSITION].equals(loginBean.getEmail()))
                    return 2;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }


}
