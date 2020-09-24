
<!DOCTYPE html>
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="css/hamburger-menu.css"> 
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/konva@5.0.3/konva.min.js"></script>
    <meta charset="utf-8" />
    <title>Graph visualiser</title>
    <style>
      body {
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #f0f0f0;
      }
    </style>
  </head>
  <body>
  

<div id="mySidenav" class="sidenav">
   <img  src="Images/Clare logo small.png">
  <a href="about.html">About</a>
  <a href="services.html">Services</a>
  <a href="meet_the_team.html">Meet the team</a>
  <a href="products.html">Products</a>
  <a href="#">Contact</a>
</div>


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



  <script >
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
  
  Node name: <input id = "node" type="text" name="name"><br>
  <button id = "createNode" value = "submit">insert node</button>
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
<form id="frm2">
  first node: <input id = "edge1" type="text" name="fname"><br>
  Second node: <input id = "edge2" type="text" name="fname"><br>
  Weight: <input id = "weight" type="text" name="fname"><br><br>
  <input id = "submit" type="submit" value="Submit">
</form>
<form id="frm3">
  find node: <input id = "getNode" type="text" name="fname"><br>
  <input id = "Nodefind" type="submit" value="Submit">
</form>
<form id="frm4">
  has Edge Start: <input id = "hasEdge1" type="text" name="fname"><br>
  has Edge Finish: <input id = "hasEdge2" type="text" name="fname"><br>
  <input id = "edge" type="submit" value="Submit">
</form>
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
//onclick="createEdge()"
//action="createNode()"

/*var circle3 = new Konva.Circle({
    x: 400,
    y: 300,
    radius: 40,
    fill: 'red',
    stroke: 'black',
    strokeWidth: 4,
    draggable: true
  });
      var circle1 = new Konva.Circle({
        x: 122,
        y: 50,
        radius: 40,
        fill: 'red',
        stroke: 'black',
        strokeWidth: 4,
        draggable: true
      });
      
      var circle2 = new Konva.Circle({
          x: 200,
          y: 350,
          radius: 40,
          fill: 'red',
          stroke: 'black',
          strokeWidth: 4,
          draggable: true
        });
      var arrow = new Konva.Arrow({
    	  points: [circle1.getX(), circle1.getY(), circle2.getX(), circle2.getY()],
          pointerLength: 20,
          pointerWidth: 20,
          fill: 'black',
          stroke: 'black',
          strokeWidth: 4
        });*/
    /*  function adjustPoint(e){
    	  console.log(arrow.points()[1]);
          var p=[arrow.points()[0], arrow.points()[1], circle2.getX(), circle2.getY()];
          arrow.setPoints(p);
          layer.draw();
        }*/

     //   circle1.on('dragmove', adjustPoint);
     //   circle2.on('dragmove', adjustPoint);
     //   circle3.on('dragmove', adjustPoint);
        
       // add the shape to the layer
    //  layer.add(circle1);
    //  layer.add(circle2);
   //   layer.add(arrow)
    //  layer.add(arrow)
      
      // add the layer to the stage
      
      stage.add(layer);
      var imageObj = new Image();
      imageObj.onload = function () {
        var background = new Konva.Image({
          x: 0,
          y: -100,
          image: imageObj,
          width: stage.width(),
          height: stage.height(),
        });
      
        // add the shape to the layer
        layer.add(background);
        layer.draw();
      };
        imageObj.src = 'Images/social-media.png';
        
      
      function createNode ()
      {
          	  console.log(document.getElementById('node').value);
          	console.log(count);
          	 var circle =  new Konva.Group({
          		    x: 400,
          		    y: 300,
          		    name: document.getElementById('node').value,
          		    id: count,
          		    radius: 40,
          		    fill: 'red',
          		    stroke: 'black',
          		    strokeWidth: 4,
          		    draggable: true
          		  })
          	 circle.add(new Konva.Circle({
          		radius: 40,
      		    fill: 'red',
          	 }));
          	circle.add(new Konva.Text({
          		text: document.getElementById('node').value,
                fontSize: 18,
                fontFamily: 'Helvetica',
                fill: '#000',
                padding: 0,
                offsetX: circle.attrs.radius/2
            }));
          	  layer.add(circle);
      			layer.draw();
      			count++;
      			
      			
      	}
      
      
      
      function createEdge ()
      {
    	  var shape1 = '';
    	  var shape2 = '';
    	  var vert1 = layer.find(shape1.concat('.',document.getElementById('edge1').value));
    	  var vert2 = layer.find(shape1.concat('.',document.getElementById('edge2').value));
          	  console.log(vert1[0].getX(), vert1[0].getX());
          	var arrow = new Konva.Arrow({
          	  points: [vert1[0].getX(), vert1[0].getY(),vert2[0].getX(),vert2[0].getY()],
                pointerLength: 20,
                pointerWidth: 20,
                fill: 'black',
                stroke: 'black',
                strokeWidth: 4
              });
    
          	  layer.add(arrow);
      			layer.draw();
      			vert1[0].on("dragmove", function()
        	    		  {
        	    	  var p=[vert1[0].getX(), vert1[0].getY(),vert2[0].getX(),vert2[0].getY()];
        	          arrow.setPoints(p);
        	          layer.draw();
        	    		  });
      			vert2[0].on("dragmove", function()
      	    		  {
      	    	  var p=[vert1[0].getX(), vert1[0].getY(),vert2[0].getX(),vert2[0].getY()];
      	          arrow.setPoints(p);
      	          layer.draw();
      	    		  });
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