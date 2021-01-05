int sensorValue;
#include "DHT.h"
#define DHTPIN 2
#define DHTTYPE DHT11
#define SPEAKER 3
DHT dht(DHTPIN, DHTTYPE);
void setup()
{
  Serial.begin(9600);      // sets the serial port to 9600
}

void loop()
{
  delay(300);                        // wait 100ms for next reading
  sensorValue = analogRead(0);       // read analog input pin 0
  
  int h = dht.readHumidity();
  int t = dht.readTemperature();
  
  Serial.print(sensorValue, DEC);  // prints the value read
  Serial.print(":");
  Serial.print(h);
  Serial.print(":");
  Serial.println(t); 
  
  if(sensorValue > 400){
     tone(SPEAKER,2400);
     delay(300);
     tone(SPEAKER,500);  
  }
  else{
    noTone(SPEAKER);
  }
}
