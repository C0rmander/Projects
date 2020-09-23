
#include "MPU9250.h"

// an MPU9250 object with the MPU-9250 sensor on I2C bus 0 with address 0x68
MPU9250 IMU(Wire,0x68);
int status;

int invertion(float x)
{
  if (x < 0)
  {
    Serial.print(fabsf(x),2);
    Serial.print(","); 
  }
  else
  {
  if (x > 0)
  {
    x = x-(x*2);
    Serial.print (x,2);
    Serial.print(",");
  }
  }
  if(x = 0)
  {
    Serial.print(x,2);
  }
}


void setup() {
  
  // serial to display data
  Serial.begin(115200);
  while(!Serial) {}
IMU.setAccelRange(MPU9250::ACCEL_RANGE_16G);
  // setting the gyroscope full scale range to +/-500 deg/s
  IMU.setGyroRange(MPU9250::GYRO_RANGE_500DPS);
  // setting DLPF bandwidth to 20 Hz
  IMU.setDlpfBandwidth(MPU9250::DLPF_BANDWIDTH_5HZ);
  // setting SRD to 19 for a 50 Hz update rate
  IMU.setSrd(19);
  IMU.calibrateGyro();
  // start communication with IMU 
  status = IMU.begin();
  if (status < 0) {
    Serial.println("IMU initialization unsuccessful");
    Serial.println("Check IMU wiring or try cycling power");
    Serial.print("Status: ");
    Serial.println(status);
    while(1) {}
  }
}

void loop() {
  // read the sensor
  IMU.readSensor();
  // display the data
  Serial.print(IMU.getAccelX_mss()*10,1);
  Serial.print(",");
  Serial.print(IMU.getAccelY_mss()*10,1);
  Serial.print(",");
  Serial.print(IMU.getAccelZ_mss()*10-((IMU.getAccelZ_mss()*10)*2),1);
  Serial.print(",");
  invertion(IMU.getGyroX_rads()*10);
  Serial.print(IMU.getGyroY_rads()*10,2);
  Serial.print(",");
  invertion(IMU.getGyroZ_rads()*10);
  Serial.print(IMU.getMagX_uT()*10,2);
  Serial.print(",");
  Serial.print(IMU.getMagY_uT()*10,2);
  Serial.print(",");
  Serial.print(IMU.getMagZ_uT()*10,2);
  Serial.print(",");
  Serial.println(IMU.getTemperature_C()*10,2);
  delay(100);
}




