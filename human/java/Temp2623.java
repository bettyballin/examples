package com.yourcompany.yourproject.keys;

public class ProjectKey {

    private String key;

    public ProjectKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ProjectKey{" +
                "key='" + key + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ProjectKey projectKey = new ProjectKey("exampleKey");
        System.out.println(projectKey);
    }
}