import serial
import firebase_admin

from firebase_admin import credentials
from firebase_admin import firestore
import time
import datetime


cred = credentials.Certificate("../3rd_project/credentials/narae.json")
firebase_admin.initialize_app(cred)
db = firestore.client()
cnt = 1

while True:
    now = datetime.datetime.now()
    uptime = now.strftime('%H%M')
    # uptime = now.strftime('%H%M')
    # uptime = str(uptime)
    print(uptime)


    data = serial.Serial('/dev/ttyACM0',9600)

    dataval = str(data.readline())[2:-5]
    
    if(dataval.count(':') == 2):
        gas = dataval.split(":")[0]
        water = dataval.split(":")[1]
        temp = dataval.split(":")[2]
        

        doc_ref = db.collection(u'3rd_project').document(u'RaspberryPi')
        doc_ref.set({
            u'uptime' : uptime,
            u'gas': gas,
            u'temp' : temp,
            u'water' : water
            })
            
            
        try:
            doc = doc_ref.get()
            print(u'Document data: {}'.format(doc.to_dict()))
        except google.cloud.exceptions.NotFound:
            print(u'No such document!')
        
        time.sleep(60)
        cnt += 1
        
        if(cnt == 60):
            doc_ref1 = db.collection(u'3rd_project').document(u'test')
            doc_ref1.set({
                u'test' : uptime     
            })
            cnt = 1
    
    else:
        print("error.. retry!")
    


    
