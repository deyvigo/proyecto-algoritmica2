<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <title>Inicio</title>
    <link rel="icon" href="Images/raccoon-with-headphones-and-reading-a-book.svg">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body class="bg-orange-500">
    <div class="my-auto flex gap-5 p-10">
        <img src="Images/raccoon-with-headphones-and-reading-a-book.svg" alt="" class="w-80 h-80 rounded-full mx-auto">
    </div>
    <div
      class="m-4 flex h-20 w-1/5 flex-row justify-between gap-4 rounded-2xl bg-red-100 p-2 shadow-sm mx-auto px-10 font-bold font-mono text-black-600 " style="font-family: 'Segoe UI', Times, serif;"
      >
        <a href="login.html" class="mx-auto my-auto active:scale-[.98] active:duration-100 transition-all ease-in-out hover:scale-[1.02] font-bold text-xl">ReadoLogic</a>               
    </div>
    <div class="my-auto flex justify-center gap-4 text-center p-4">
        <a href="login.html" class="bg-gray-400 border-2 border-black rounded-2xl py-2 px-3 shadow-xl my-auto active:scale-[.98] active:duration-100 transition-all ease-in-out hover:scale-[1.02] font-bold">Ingresar</a>
        <a href="signup.html" class="bg-red-500 rounded-2xl py-2 px-3 shadow-xl my-auto border-2 hover:bg-red-400 hover:border-2 hover:border-black active:scale-[.98] active:duration-100 transition-all ease-in-out hover:scale-[1.02] border-black border-2 font-bold">Registrarse</a>
    </div>  
  </body>
</html>
