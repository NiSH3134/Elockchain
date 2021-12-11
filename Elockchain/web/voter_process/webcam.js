function configure()
{
    Webcam.set
    (
        {
            
        
        image_format: 'jpeg',
        jpeg_quality: 90,
                    constraints: {
            width: { exact: 1280 },
            height: { exact: 720 }
        } 
        
            
        }
    );
    Webcam.attach( '#my_camera' );
}


var data="a";
function take_snapshot()
{
    // play sound effect
    // take snapshot and get image data
    Webcam.snap
    ( 
        function(data_uri) 
        {
            // display results in page
            data=data_uri;
            document.getElementById('results').innerHTML = '<img id="imageprev" src="'+data_uri+'"/>';
        } 
    );
    var a=document.getElementById("txt");
    a.value=data;
    console.log(data);
    console.log(a.value);
    Webcam.reset();   
}