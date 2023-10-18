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
    <div
      class="m-4 flex h-20 w-4/5 flex-row justify-between gap-4 rounded-2xl bg-red-100 p-2 shadow-sm mx-auto px-10 font-bold font-mono text-black-600 " style="font-family: 'Segoe UI', Times, serif;"
    >
      <div class="my-auto flex gap-3">
        <img src="Images/raccoon-with-headphones-and-reading-a-book.svg" alt="" class="w-10 h-10 rounded-2xl">
        <a href="" class="my-auto text-unispace">Education</a>
      </div>
      <div class="my-auto flex gap-4">
        <a href="user.jsp" class="">Usuario</a>
        <a href="" class="">Opciones</a>
        <a href="" class="">Opciones</a>
      </div>
      <div class="my-auto flex justify-center gap-2 text-center">
        <a href="login.html" class="border-2 border-black rounded-2xl py-2 px-3 shadow-xl my-auto active:scale-[.98] active:duration-100 transition-all ease-in-out hover:scale-[1.02]">Ingresar</a>
        <a href="signup.html" class="bg-red-500 rounded-2xl py-2 px-3 shadow-xl my-auto border-2 border-transparent hover:bg-red-400 hover:border-2 hover:border-black active:scale-[.98] active:duration-100 transition-all ease-in-out hover:scale-[1.02]">Registrarse</a>
      </div>
    </div>
  </body>
</html>
