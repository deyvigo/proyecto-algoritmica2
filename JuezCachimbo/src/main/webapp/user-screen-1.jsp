<%@page import="com.mycompany.juezcachimbo.clases.Pregunta"%>
<%@page import="com.mycompany.juezcachimbo.clases.Texto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://kit.fontawesome.com/4fb2d199eb.js" crossorigin="anonymous"></script>
    <title>Usuario</title>
  </head>
  <body class="bg-orange-500 flex p-8 gap-8">
    <!-- card user -->
    <div class="w-1/5 flex flex-col items-center bg-gray-800 min-h-[92%] p-4 rounded-3xl mb-8 gap-8 fixed left-[10%] border-purple-950 border-2">
      <div class="p-2 flex-col">
        <img src="Images/raccoon-with-headphones-and-reading-a-book-on-back (1).svg" alt="" class="rounded-full w-11/12 h-11/12 mx-auto border-2 border-black">
        <p class="text-center text-white font-bold pt-2">Alumno: Deyvi Gomez</p>
      </div>
      <div class="flex flex-col gap-4 h-full w-10/12 indent-4">
        <a href="" class="bg-orange-500 h-12 w-[100%] flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Notas</a>
        <a href="" class="bg-orange-500 h-12 flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Notas</a>
        <a href="" class="bg-orange-500 h-12 flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Notas</a>
        <a href="" class="bg-orange-500 h-12 flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Notas</a>
      </div>
      <div class="h-full w-[75%] indent-4 absolute top-[90%]" >
        <a href="" class="bg-orange-500 h-12 flex items-center rounded-xl active:scale-[0.98] hover:scale-[1.02] transition-all duration-100 font-bold text-lg border-2 border-black">Salir</a>
      </div>
    </div>
    <!-- right bar -->
    <div class="absolute right-[10%] w-[58%] h-[92%] flex flex-col gap-4">
      <!-- search bar -->
      <div class="w-[100%]">
        <form action="" class="flex items-center">
          <input class="w-[95%] h-12 border-black border-2 rounded-lg indent-2 focus:outline-none" type="text">
          <button class="w-[5%] h-8 scale-[1.5] flex items-center justify-center" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
        </form>
      </div>
      <!-- text-content -->
      <div class="w-[100%] bg-gray-800 text-white p-8 rounded-3xl flex flex-col gap-4 h-[100%] overflow-auto">
        <% 
          Texto text = (Texto)request.getSession().getAttribute("text");
        %>
        <h1 class="text-center text-3xl font-bold">TEXTO</h1>  
        <h1>
          <%=text.getTexto()%>
        </h1>
        <h1 class="indent-1 font-semibold">Pregunta</h1>
        <%int cont=1;%>
        <%for (Pregunta p : text.getPreguntas()){%>
        <div class="flex flex-col gap-2 border-2 rounded-lg py-2 px-4">
          <h1><%=cont + ". " + p.getPregunta()%></h1>
          <div class="hover:bg-gray-600 py-1 px-2 rounded-md">
            <input type="radio" name="1" id="first">
            <label for="first" class="px-2">Opción 1</label>
          </div>
          <div class="hover:bg-gray-600 py-1 px-2 rounded-md">
            <input type="radio" name="1" id="second">
            <label for="second" class="px-2">Opción 2</label>
          </div>
          <div class="hover:bg-gray-600 py-1 px-2 rounded-md">
            <input type="radio" name="1" id="third">
            <label for="third" class="px-2">Opción 3</label>
          </div>
          <div class="hover:bg-gray-600 py-1 px-2 rounded-md">
            <input type="radio" name="1" id="fourth">
            <label for="fourth" class="px-2">Opción 4</label>
          </div>
          <%cont++;%>
          <%}%>
        </div>
      </div>

  </body>
</html>
