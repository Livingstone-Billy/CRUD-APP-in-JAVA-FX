package com.example.main;

import com.mongodb.*;

import java.util.Map;

public class StudentDB {

    final static String DB_name = "StudentDB";
    final static String collection= "StudentDetails";

    //inserting student data int database
    public static void insertStudentDetails(
            String firstName, String middleName, String lastName,
            String D_of_birth, String id_no, String reg_no, String currentYear,
            String studyLevel, String courseName
    ){
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB(DB_name);
            System.out.println("Connected to database "+DB_name+".DB successfully");

            DBCollection dbCollection = db.getCollection(collection);

            System.out.println("Collection "+collection+" accessed correctly");

            BasicDBObject studentDoc = new BasicDBObject("FirstName", firstName).
                    append("MiddleName", middleName).append("LastName", lastName).
                    append("Date of Birth", D_of_birth).append("ID No", id_no)
                            .append("Registration No", reg_no).append("Current Year", currentYear)
                            .append("Study Level", studyLevel).append("CourseName", courseName);

            dbCollection.insert(studentDoc);
            System.out.println("Document "+studentDoc+" inserted successfully");

        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": "+e.getMessage());
        }
    }

    public static boolean loginRoute(String password){

        boolean isLogin = false;

        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);

            DB db = mongoClient.getDB(DB_name);
            System.out.println("Connection to database, Successful!");

            DBCollection collection_ = db.getCollection(collection);
            System.out.println("Collection accessed correctly");

            DBObject query = new BasicDBObject().append("ID No", password);

            DBObject result = collection_.findOne(query);

            if (result == null){
                isLogin = false;
            }
            if (result.get("ID No").equals(password)){
                isLogin = true;
            }
        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
        }

        return isLogin;
    }

    public static Map<String, String> getStudentDetails(String key){

        Map<String, String> retrievedData = null;

        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);

            DB db = mongoClient.getDB(DB_name);
            System.out.println("Database Connection status: {OK}");

            DBCollection collection_ = db.getCollection(collection);
            System.out.println("Access Status: {OK}");

            DBObject query = new BasicDBObject().append("ID No", key);

            DBObject result = collection_.findOne(query);

            System.out.println("Retrieval Status: {OK}");

            retrievedData = result.toMap();

        }catch (Exception e)
        {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return retrievedData;
    }
}
