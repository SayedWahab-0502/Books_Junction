package com.wahab.books_junction;

public class User_Profile
{
    public String userName;
    public String userEmail;
    public String userdob;
    public String usermobno;
    public String useradd;

    public User_Profile()
    {
    }

    public User_Profile(String userName,String usermail,String dob,String mobno,String addd)
    {
        this.userName = userName;
        this.userEmail = usermail;
        this.userdob=dob;
        this.usermobno=mobno;
        this.useradd=addd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserdob() {
        return userdob;
    }

    public void setUserdob(String userdob) {
        this.userdob = userdob;
    }


    public String getUsermobno() {
        return usermobno;
    }

    public void setUsermobno(String usermobno) {
        this.usermobno = usermobno;
    }

    public String getUseradd() {
        return useradd;
    }

    public void setUseradd(String useradd) {
        this.useradd = useradd;
    }


}
