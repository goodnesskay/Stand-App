package me.goodnesskayode.stand;

/**
 * Created by goodness on 5/15/17.
 */

public class User {

    private String fullName;
    private String userName;
    private String email;

    public User(){}

    public User(String fullName,String userName, String email)
    {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
    }

    public void setFullName(String fullName)
    {
        this.fullName =fullName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getfullName()
    {
        return fullName;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }


}
