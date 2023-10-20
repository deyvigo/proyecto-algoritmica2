<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Login</title>
    <link rel="icon" href="Images/raccoon-with-headphones-and-reading-a-book.svg">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body>
    <section class="bg-[#D8CDB1] min-h-screen flex justify-center items-center">
      <!-- container -->
      <div
        class="bg-[#8895C0] w-1/2 h-3/4 mx-auto flex justify-between rounded-3xl p-4 shadow-2xl gap-4"
      >
        <!-- content -->
        <form action="LoginServ" method="POST" class="flex mx-auto my-auto flex-col gap-5 m-4 p-5">
          <h1 class="text-center font-bold text-2xl">INGRESAR</h1>
          <div class="flex flex-col gap-6">
            <div class="flex flex-col gap-1">
              <label for="" class="indent-2">Usuario</label>
              <input
                type="text" placeholder="mokoko" name="user"
                class="border-2 border-black rounded-lg focus:outline-none indent-3 p-1"
              />
            </div>
            <div class="flex flex-col gap-1">
              <label for="" class="indent-2">Contraseña</label>
              <input
                type="password" placeholder="mokoker" name="contrasena"
                class="border-2 border-black rounded-lg focus:outline-none indent-3 p-1"
              />
            </div>

            <button type="submit" class="shadow-xl rounded-xl bg-red-500 hover:bg-red-400 p-2 active:scale-[.98] active:duration-100 transition-all ease-in-out hover:scale-[1.02] border-2 border-black font-bold text-gray-100">Ingresar</button>

          </div>
        </form>
        <!-- image -->
        <div class="w-1/2 h-auto p-4">
          <img
            src="Images/books.jpg"
            alt=""
            class="rounded-2xl h-full object-cover"
          />
        </div>
      </div>
    </section>
  </body>
</html>
