<%@page import="com.mycompany.juezcachimbo.clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Usuario</title>
    <link rel="icon" href="Images/raccoon-with-headphones-and-reading-a-book.svg">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://kit.fontawesome.com/4fb2d199eb.js" crossorigin="anonymous"></script>
  </head>
  <!-- <body class="bg-purple-500 flex justify-center p-8 gap-8"> -->
  <!-- card user -->
    <!-- <div class="w-1/5 flex flex-col items-center bg-pink-700 min-h-[92%] p-4 rounded-3xl mb-8 gap-8 fixed left-[10%] border-purple-950 border-2"> -->
      <!-- <div class="p-2 flex-col"> -->
        <!-- <img src="Images/raccoon-with-headphones-and-reading-a-book-on-back (1).svg" alt="" class="rounded-full w-11/12 h-11/12 mx-auto border-2 border-black"> -->
        <!-- <p class="text-center font-bold pt-2">Alumno: Deyvi Gomez</p> -->
      <!-- </div> -->
      <!-- <div class="flex flex-col gap-4 h-full w-10/12 indent-4"> -->
        <!-- <a href="" class="bg-purple-800 h-12 flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Notas</a> -->
        <!-- <a href="" class="bg-purple-800 h-12 flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Notas</a> -->
        <!-- <a href="" class="bg-purple-800 h-12 flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Notas</a> -->
        <!-- <a href="" class="bg-purple-800 h-12 flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Notas</a> -->
      <!-- </div> -->
      <!-- <div class="h-full w-10/12 indent-4 absolute top-[90%]" > -->
        <!-- <a href="" class="bg-purple-800 h-12 flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Salir</a> -->
      <!-- </div> -->
    <!-- </div> -->
    <!-- content text -->
    <!-- <div class="w-[58%] absolute right-[10%]"> -->
      <!-- <form action="SearchButtonServ" method="GET" class="flex items-center"> -->
        <!-- <input class="w-11/12 h-10 border-black border-2 rounded-lg indent-2 focus:outline-none" type="text"> -->
        <!-- <button class="w-1/12 h-8 scale-[1.5] flex items-center justify-center" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button> -->
      <!-- </form> -->
    <!-- </div> -->
  <!-- </body> -->
  <%Usuario user = (Usuario)request.getSession().getAttribute("user");%>
  <body class="bg-orange-500 flex p-8 gap-8">
    <!-- card user -->
    <div class="w-1/5 flex flex-col items-center bg-gray-400 min-h-[92%] p-4 rounded-3xl mb-8 gap-0 fixed left-[10%] border-blue-950 border-2">
      <div class="w-full h-[calc(20vw-1rem-2px)] flex flex-col items-center justify-center p-2 gap-1">
        <img src="Images/raccoon-with-headphones-and-reading-a-book-on-back (1).svg" alt="" class="object-cover rounded-full">
        <h1 class="font-semibold">Nombre: <%=user.getNombres()%></h1>
      </div>
    <!-- menu -->
    <div class="w-[95%] h-[calc(30vw-0.2rem)] flex flex-col justify-between">
      <ul class="flex flex-col gap-2">
        <div class="flex items-center justify-center hover:bg-orange-300 hover:rounded-lg pl-4">
          <ion-icon name="person-outline" class="w-[25px] h-[25px]"></ion-icon>
          <a href="" class="font-bold w-full h-auto border-black p-2">Perfil</a>
        </div>
        <div class="flex items-center justify-center hover:bg-orange-300 hover:rounded-lg pl-4">
          <ion-icon name="stats-chart-outline" class="w-[25px] h-[25px]"></ion-icon>
          <a href="" class="font-bold w-full h-auto border-black p-2">Estadística</a>
        </div>
        <div class="flex items-center justify-center hover:bg-orange-300 hover:rounded-lg pl-4">
          <ion-icon name="document-text-outline" class="w-[25px] h-[25px]"></ion-icon>
          <a href="" class="font-bold w-full h-auto border-black p-2">Textos</a>
        </div>
        <div class="flex items-center justify-center hover:bg-orange-300 hover:rounded-lg pl-4">
          <ion-icon name="caret-forward-outline" class="w-[25px] h-[25px]"></ion-icon>
          <a href="" class="font-bold w-full h-auto border-black p-2">Notas</a>
        </div>
      </ul>
      <div class="w-[95%] flex flex-col justify-between">
        <div class="flex items-center justify-center hover:bg-orange-300 hover:rounded-lg pl-4">
          <ion-icon name="exit-outline" class="w-[25px] h-[25px]"></ion-icon>
          <a href="" class="font-bold w-full h-auto border-black p-2">Salir</a>
        </div>
      </div>
    </div> 
    </div>
    <!-- right bar -->
    <div class="absolute right-[10%] w-[58%] h-[92%] flex flex-col gap-4">
      <!-- search bar -->
      <div class="w-[100%]">
        <form action="SearchButtonServ" class="flex items-center">
          <input class="w-[100%] h-12 border-black border-2 rounded-2xl indent-4 focus:outline-none" type="text" placeholder="Palabras clave...">
          <button class="w-[4%] h-8 scale-[1.5] flex items-center justify-start absolute -right-[0%]" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
        </form>
      </div>
      <!-- text-content -->
      <div class="w-[100%] bg-gray-400 border-2 border-black text-white p-8 rounded-3xl flex flex-col gap-4 h-[100%]">
        
        </div>
      </div>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
  </body>
</html>
