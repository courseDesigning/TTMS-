package com.example.katherine_qj.ttms.model;

/**
 * Created by katherine on 5/31/17.
 */

public class PeopleOnline {
    private PeopleOnline() {
    }

    // 将自身的实例对象设置为一个属性,并加上Static和final修饰符
    private static final PeopleOnline instance = new PeopleOnline();

    // 静态方法返回该类的实例
    public static PeopleOnline getInstance() {
        return instance;
    }
    private String Ssession_id;

    public String getSsession_id() {
        return Ssession_id;
    }

    public void setSsession_id(String ssession_id) {
        Ssession_id = ssession_id;
    }
}
