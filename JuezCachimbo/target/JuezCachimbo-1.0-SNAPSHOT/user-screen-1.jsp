<%@page import="com.mycompany.juezcachimbo.clases.Pregunta"%>
<%@page import="com.mycompany.juezcachimbo.clases.Texto"%>
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
  <body class="bg-[#8895C0] flex p-8 gap-8">
    <!-- card user -->
    <div class="w-1/5 flex flex-col items-center bg-[#D8CDB1] min-h-[91.5%] p-4 rounded-3xl mb-8 gap-0 fixed left-[10%] border-black border-2">
      <div class="w-full h-[20%] flex flex-col items-center justify-center p-2 gap-1">
        <img src="Images/raccoon-with-headphones-and-reading-a-book-on-back (1).svg" alt="" class="object-cover rounded-full">
        <h1 class="font-semibold">Nombre: Mokoko</h1>
      </div>
    <!-- menu -->
    <div class="w-[95%] h-[48vh] flex flex-col justify-between gap-2">
      <ul class="flex flex-col gap-1">
        <div class="flex items-center justify-center hover:bg-[#5b6895] hover:rounded-lg pl-4">
          <ion-icon name="person-outline" class="w-[25px] h-[25px]"></ion-icon>
          <a href="" class="font-bold w-full h-auto border-black p-2">Perfil</a>
        </div>
        <div class="flex items-center justify-center hover:bg-[#5b6895] hover:rounded-lg pl-4">
          <ion-icon name="stats-chart-outline" class="w-[25px] h-[25px]"></ion-icon>
          <a href="" class="font-bold w-full h-auto border-black p-2">Estadística</a>
        </div>
        <div class="flex items-center justify-center hover:bg-[#5b6895] hover:rounded-lg pl-4">
          <ion-icon name="document-text-outline" class="w-[25px] h-[25px]"></ion-icon>
          <a href="" class="font-bold w-full h-auto border-black p-2">Textos</a>
        </div>
        <div class="flex items-center justify-center hover:bg-[#5b6895] hover:rounded-lg pl-4">
          <ion-icon name="caret-forward-outline" class="w-[25px] h-[25px]"></ion-icon>
          <a href="" class="font-bold w-full h-auto border-black p-2">Notas</a>
        </div>
      </ul>
      <div class="w-[100%] flex flex-col justify-between">
        <div class="flex items-center justify-center hover:bg-[#5b6895] hover:rounded-lg pl-4">
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
      <div class="w-[100%] bg-[#D8CDB1] text-black border-2 border-black p-8 rounded-3xl flex flex-col gap-2 h-[100%] overflow-auto text-sm">
        <% 
        Texto text = (Texto)request.getSession().getAttribute("text");
      %>
      <h1 class="text-center text-2xl font-bold">TEXTO</h1>  
      <h1>
        <%=text.getTexto()%>
      </h1>
      <h1 class="indent-1 font-semibold">Pregunta</h1>
      <%int cont=1;%>
      <%for (Pregunta p : text.getPreguntas()){%>
        <div class="flex flex-col gap-2 border-2 border-[#5B6895] rounded-lg py-2 px-4">
          <h1><%=cont + ". " + p.getPregunta()%></h1>
          <div class="hover:bg-gray-400 py-1 px-2 rounded-md">
            <input type="radio" name="pregunta_<%=cont%>" id="first_<%=cont%>">
            <label for="first_<%=cont%>" class="px-2"><%=p.getAlternativas().get(0)%></label>
          </div>
          <div class="hover:bg-gray-400 py-1 px-2 rounded-md">
            <input type="radio" name="pregunta_<%=cont%>" id="second_<%=cont%>">
            <label for="second_<%=cont%>" class="px-2"><%=p.getAlternativas().get(1)%></label>
          </div>
          <div class="hover:bg-gray-400 py-1 px-2 rounded-md">
            <input type="radio" name="pregunta_<%=cont%>" id="third_<%=cont%>">
            <label for="third_<%=cont%>" class="px-2"><%=p.getAlternativas().get(2)%></label>
          </div>
          <div class="hover:bg-gray-400 py-1 px-2 rounded-md">
            <input type="radio" name="pregunta_<%=cont%>" id="fourth_<%=cont%>">
            <label for="fourth_<%=cont%>" class="px-2"><%=p.getAlternativas().get(3)%></label>
          </div>
          <div class="hover:bg-gray-400 py-1 px-2 rounded-md">
            <input type="radio" name="pregunta_<%=cont%>" id="fifth_<%=cont%>">
            <label for="fifth_<%=cont%>" class="px-2"><%=p.getAlternativas().get(4)%></label>
          </div>
        </div>
      <%cont++;%>
      <%}%>
        <div class="bg-red-500 w-[15%] mx-auto rounded-2xl text-center shadow-2xl hover:scale-[1.02] active:scale-[0.98] duration-100 font-bold text-gray-950">
          <button type="submit" class="w-[100%] h-[1005] p-2">Enviar</button>
        </div>
        </div>
      </div>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
  </body>
</html>
