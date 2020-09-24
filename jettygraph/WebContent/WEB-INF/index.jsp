
<!DOCTYPE html>
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="css/hamburger-menu.css">
   <link rel="stylesheet" type="text/css" href="css/stylesheet.css"> 
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/konva@5.0.3/konva.min.js"></script>
    <meta charset="utf-8" />
    <title>Graph visualiser</title>
    <style>
html
  {
  overflow: hidden;
  }
body {
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #f0f0f0;
     }
input[type=text], select 
{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
.inputLab
{
  color: white;
}

.logo
{
max-width: 100%;
}
      
input[type=submit] 
{
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
    </style>
  </head>
  <body>
  

<div id="mySidenav" class="sidenav">
   <img class="logo"  src="Images/animal-logo.png">
   <br>
   <br>
   <label class = "inputLab" for="fname">Enter name of person to add to network</label>
   <input id = "node" type="text" name="name"><br>
  <input id = "createNode" type ="submit" value = "submit">
  <form id="frm2">
  <br><br><br>
  <label class = "inputLab" for="fname">create relationship between persons with weight</label>
  <label class = "inputLab" for="fname">First Person</label>
  <input id = "edge1" type="text" name="fname"><br>
  <label class = "inputLab" for="fname">Second Person</label>
  <input id = "edge2" type="text" name="fname"><br>
  <label class = "inputLab" for="fname">Weight of relationship</label>
  <input id = "weight" type="text" name="fname"><br>
  <input id = "submit" type="submit" value="Submit">
  
  <label class = "inputLab" for="fname">remove relationship between persons</label>
  <label class = "inputLab" for="fname">First Person</label>
  <input id = "person1" type="text" name="fname"><br>
  <label class = "inputLab" for="fname">Second Person</label>
  <input id = "person2" type="text" name="fname"><br>
  <input id = "remove" type="submit" value="Submit">
</form>
</div>

 <!-- <form id="frm3">
  <label class = "inputLab" class = "inputLab" for="fname">Check if node exists</label>
  <input id = "getNode" type="text" name="fname"><br>
  <input id = "Nodefind" type="submit" value="Submit">
</form>-->

<!--  <form id="frm4">
  <label class = "inputLab" for="fname">Check if relationship exists</label>
  <label class = "inputLab" for="fname">First Person</label>
  <input id = "hasEdge1" type="text" name="fname"><br>
  <label class = "inputLab" for="fname">Second Person</label>
  <input id = "hasEdge2" type="text" name="fname"><br>
  <input id = "edge" type="submit" value="Submit">
</form>-->

<!-- Add all page content inside this div if you want the side nav to push page content to the right (not used if you only want the sidenav to sit on top of the page -->
<div id="main">
  
  <div id="slider" class="buttonbox">
  <div id="button-anim" class="bttn not-active">

    <span></span>
    <span></span>
    <span></span>

  </div>

</div>

</div>



  <script>
    function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "-250px";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft = "0";
}
  </script>
  
  
<script type="text/javascript">
$( document ).ready(function(){
	$('#createNode').click(function() {
		createNode()
		event.preventDefault();
		console.log("ajax test")
		console.log(document.getElementById('node').value)
	    $.ajax({
	        type: 'POST',
	        data: {
	            node: document.getElementById('node').value
	        }
	          
	    });
	});
$('#submit').click(function() {
	createEdge ()
	event.preventDefault();
	console.log("ajax test")
	console.log(document.getElementById('node').value)
    $.ajax({
        type: 'POST',
        data: {
            edge1: document.getElementById('edge1').value,
            edge2: document.getElementById('edge2').value,
            weight: document.getElementById('weight').value
        }
          
    });
});

$('#remove').click(function() {
	event.preventDefault();
	removeEdge()
	$.ajax({
        type: 'POST',
        data: {
            removeEdge1: document.getElementById('person1').value,
            removeEdge2: document.getElementById('person2').value
        }
          
    });
});


$('#Nodefind').click(function() {
	event.preventDefault();
	console.log("ajax test")
	console.log(document.getElementById('node').value)
    $.ajax({
        type: 'POST',
        data: {
            getNode: document.getElementById('getNode').value
        }
          
    });
});


$('#edge').click(function() {
	event.preventDefault();
	console.log("ajax test")
	console.log(document.getElementById('node').value)
    $.ajax({
        type: 'POST',
        data: {
            hasEdge1: document.getElementById('hasEdge1').value,
            hasEdge2: document.getElementById('hasEdge2').value
        }
          
    });
});
});
</script>

    <div id="container"></div>
    <script>
    var count = 0;
      var width = window.innerWidth;
      var height = window.innerHeight;

      var stage = new Konva.Stage({
        container: 'container',
        width: width,
        height: height
      });

      var layer = new Konva.Layer();
      // add the layer to the stage
      
      stage.add(layer);
      var imageObj = new Image();
      imageObj.onload = function () {
        var background = new Konva.Image({
          x: 0,
          y: 0,
          image: imageObj,
          width: stage.width(),
          height: stage.height()+50,
        });
      
        // add the shape to the layer
        layer.add(background);
        layer.draw();
      };
        imageObj.src = 'Images/menu-img.svg';
        
      
      function createNode ()
      {
    	  var imageNode = new Image();
    	  var x = Math.floor(Math.random() * 8)+1;
    	  var file = 'Images/Avatar' + x +'.png';
    	  console.log(file)
          imageNode.src = file;
          	  console.log(document.getElementById('node').value);
          	console.log(count);
          	
          	 var circle =  new Konva.Group({
          		    x: 400,
          		    y: 300,
          		  width: 50,
                  height: 50,
          		    name: document.getElementById('node').value,
          		    id: count,
          		  image: imageNode,
          		    draggable: true
          		  })
          	 
          	imageNode.onload = function () {
            circle.add(new Konva.Image({
                image: imageNode,
                width: 100,
                height: 100,
              }));
            
            circle.add(new Konva.Text({
          		text: document.getElementById('node').value,
                fontSize: 18,
                fontFamily: 'Helvetica',
                fill: '#000',
                padding: 0,
                offsetX: -(circle.attrs.width)/2
            }));
          	layer.draw();
          	
          	
          	};
            
          	
          	
          	  layer.add(circle);
          	layer.batchDraw();
      			layer.draw();
      			count++;
      			
      			
      	}
      
      
      
      function createEdge ()
      {
    	  var shape1 = '';
    	  var shape2 = '';
    	  var vert1 = layer.find(shape1.concat('.',document.getElementById('edge1').value));
    	  var vert2 = layer.find(shape1.concat('.',document.getElementById('edge2').value));
    	  var arrowName = document.getElementById('edge1').value + document.getElementById('edge2').value
          	  console.log(vert1[0].getX(), vert1[0].getX());
          	var arrow = new Konva.Arrow({
          	  points: [vert1[0].getX()+50, vert1[0].getY()+50,vert2[0].getX()+50,vert2[0].getY()+50],
                pointerLength: 20,
                pointerWidth: 20,
                fill: 'black',
                stroke: 'black',
                id: arrowName,
                strokeWidth: 4
              });
    			
          	  layer.add(arrow);
      			layer.draw();
      			console.log(arrowName)
      			vert1[0].on("dragmove", function()
        	    		  {
        	    	  var p=[vert1[0].getX()+50, vert1[0].getY()+50,vert2[0].getX()+50,vert2[0].getY()+50];
        	          arrow.setPoints(p);
        	          layer.draw();
        	    		  });
      			vert2[0].on("dragmove", function()
      	    		  {
      	    	  var p=[vert1[0].getX()+50, vert1[0].getY()+50,vert2[0].getX()+50,vert2[0].getY()+50];
      	          arrow.setPoints(p);
      	          layer.draw();
      	          
      	    		  });
      	}
      function removeEdge ()
      {
    	  var shape = '#'+ document.getElementById('person1').value + document.getElementById('person2').value
    	  console.log(shape)
  		layer.find(shape)[0].destroy()
  		layer.draw()
      }
    </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
     <script>
   var bttn = $('.bttn');
var bool = 0;
bttn.on('click', function() {
  
  
  if (bool == 0)
  {
    $('#slider').animate({"margin-right": '+=270'});
    document.getElementById("button-anim").classList.add('active');
    document.getElementById("button-anim").classList.remove('not-active');
    openNav();
    console.log(bool);
    bool = 1;
    console.log(bool);
    return;
  }
  if (bool = 1)
  {
    $('#slider').animate({"margin-right": '-=270'});
    document.getElementById("button-anim").classList.add('not-active');
    document.getElementById("button-anim").classList.remove('active');
    console.log('hi!');
    closeNav();
    bool = 0;
  }
  
});
  </script>
  </body>
</html>