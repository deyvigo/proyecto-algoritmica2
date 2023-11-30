let btnAdd = document.querySelector(".add-question-btn");
let container = document.querySelector(".form-container");
let component = document.querySelector(".content-component");
let indexQuestion = 2;


btnAdd.addEventListener("click", () => {
    let newComponent = component.cloneNode(true);

    //limpia los inputs
    let inputElements = newComponent.querySelectorAll('input');
    inputElements.forEach(function(input) {
        input.value = ''
    });

    //cambia los nombres de los inputs
    newComponent.querySelector(".pregunta").name = "pregunta_" + indexQuestion;
    let indexAnswer = 1;
    let alternativas = newComponent.querySelectorAll(".alternativas")
    console.log(alternativas)
    alternativas.forEach(function(alternativa) {
        alternativa.name = "alternativas_" + indexQuestion + "_" + indexAnswer;
        indexAnswer++;
    })
    newComponent.querySelector(".respuesta").name = "respuesta_" + indexQuestion;
    newComponent.querySelector(".razonamiento").name = "razonamiento_" + indexQuestion;
    indexQuestion++
    container.appendChild(newComponent);
})
