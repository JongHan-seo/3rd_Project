package com.firebase;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class App {
    private FirebaseOptions option;
    private Firestore db; 
    private final static String PATH = "C:/eGovFrame-3.9.0/bin/narae.json";
    private final static String COLLECTION_NAME = "3rd_project";
    
    public static void main( String[] args ) {
        App app = new App();
        try {
            app.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void init() throws Exception{
        FileInputStream refreshToken = new FileInputStream(PATH);
        option = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .setDatabaseUrl("https://narae-b14a6.firebaseapp.com")  //내 저장소 주소
                .build();
        FirebaseApp.initializeApp(option);
    }
    
    public void makeDatabaseConn(){  //Firestore 인스턴스 생성
        db = FirestoreClient.getFirestore();
    }
    
    
   public void select(){    // 조회
        db.collection(COLLECTION_NAME).addSnapshotListener( (target, exception)->{
            System.out.println(" - select start - ");
            target.forEach( item->{
                System.out.println("primary id : "+item.getId() + "  ||  value : " + item.getData());
            });
            System.out.println(" - select end - ");
        });
    }
    
    public void insert(){    // 문서를 추가 생성 - 이 기능은 안 쓸 듯
        Map<Object, Object> item = new HashMap<Object, Object>();
        item.put("arr", "250");
        item.put("temp", "20");
        db.collection(COLLECTION_NAME).add(item);
    }

    public void update(){
        Map<String, Object> update = new HashMap<String, Object>();
        update.put("arr", "250");
        update.put("temp", "20");
        db.collection(COLLECTION_NAME).document("RaspberryPi").update(update);
    }

    public void delete(){    // 문서 삭제 기능. 당연히 안 쓸 듯
        db.collection(COLLECTION_NAME).document("RaspberryPi").delete();
    }
    
    
}
