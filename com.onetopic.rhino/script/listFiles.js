   importPackage(java.io);
   var rootDir = new File("c:/");
   var files = rootDir.listFiles();
   var fixlength=40;
   for(var i=0;i<files.length;i++){
   var apath=files[i].getAbsolutePath();
   print(apath);
   for(var j=0;j<fixlength-apath.length();j++)
   print(" ");
   println((files[i].isDirectory()?"dir":"file"));
   };