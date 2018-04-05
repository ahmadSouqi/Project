package com.controller;

/**
 * Created by asouqi on 4/1/18.
 */
public class ControllerFactory {

    public static Controller getController(String controller){
        switch (controller){
            case "login.action":return new LogInController();

            case "getUsers.action":return new UsersCrudController();
            case "getQuestionBanks.action": return new QuestionBanksCrudController();
            case "getQuestionBanksTeachers.action": return new TeacherQuestionBankCrudController();

            case "getTeacherQuestionBanks.action": return new TeacherQuestionBank();
            case "getQuestionGroup.action": return null;
        }
        return null;
    }
}
