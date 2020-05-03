handlePosts();

function savePost(post){
    console.log('Post saved',post);
}

function handlePosts() {
    var posts = [
      { id: 23, title: 'Daily JS News' },
      { id: 52, title: 'Code Refactor City' },
      { id: 105, title: 'The Brightest Ruby' }
    ];
   
    posts.forEach(
        function(post){
            savePost(post);
        }
    );
}

var images = [
    { height: 10, width: 30 },
    { height: 20, width: 90 },
    { height: 54, width: 32 }
  ];
var areas = [];

const areaCalculator = (height,width) => {
    areas.push(height*width);
}

images.forEach(
    (image) => areaCalculator(image.height,image.width)
);
console.log("Areas caluclated",areas);





