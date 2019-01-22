package com.franyow.myappdagger.login;

public interface LoginActivityMVP {

    interface View{
        String getFirstName();
        String getLastName();

        void showUserNotAvalaible();
        void showInputError();
        void showUserSaved();

        void setFirstName(String firstName);
        void setLastName(String lastName);


    }

    interface Presenter{
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();

        void gentCurrentUser();

    }

    interface Model{
        void createUser(String firstName, String lastName);

        User getUser();
    }


}
