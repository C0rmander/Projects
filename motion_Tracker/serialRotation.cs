using UnityEngine;
using System.Collections;
using System.IO.Ports;

public class serialRotation : MonoBehaviour {

	SerialPort stream = new SerialPort("\\\\.\\COM14", 115200); //Set the port (com4) and the baud rate (9600, is standard on most devices)
	float[] lastRot = {0,0,0}; //Need the last rotation to tell how far to spin the camera


	void Start () {
		stream.Open(); //Open the Serial Stream.
	}

	// Update is called once per frame
	void Update () {
		string value = stream.ReadLine();
		 //Read the information
		string[] vec3 = value.Split(',');
		Debug.Log (vec3[8].ToString() + "," + value);
			transform.Rotate(           //Rotate the camera based on the new values
				float.Parse(vec3[3]),
				float.Parse(vec3[4]),
				float.Parse(vec3[5]),
				Space.Self
			);
		;
			lastRot[0] = float.Parse(vec3[3]);  //Set new values to last time values for the next loop
			lastRot[1] = float.Parse(vec3[5]);
			lastRot[2] = float.Parse(vec3[4]);
			stream.BaseStream.Flush(); //Clear the serial information so we assure we get new information.

	}

	void OnGUI()
	{
		string newString = "Connected: " + transform.rotation.x + ", " + transform.rotation.y + ", " + transform.rotation.z;
		GUI.Label(new Rect(10,10,300,100), newString); //Display new values
	}

}
