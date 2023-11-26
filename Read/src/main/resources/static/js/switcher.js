const alumnBtn = document.querySelector(".alumnBtn")
const teacherBtn = document.querySelector(".teacherBtn")
const imgTeacher = document.querySelector(".imgTeacher")
const imgAlumn = document.querySelector(".imgAlumn")
const cardTeacher = document.querySelector(".cardTeacher")
const cardAlumn = document.querySelector(".cardAlumn")
const switcher = document.querySelector(".switcher")
const inputsAlumn = document.querySelectorAll(".inputAlumn")
const inputsTeacher = document.querySelectorAll(".inputTeacher")

alumnBtn.addEventListener("click", () => {
    switcher.style.transform = "translateX(0%)"
    cardTeacher.style.visibility = "hidden"
    cardAlumn.style.transform = "translateX(0%)"
    cardAlumn.style.visibility = "visible"
    cardAlumn.style.zIndex = 10;
    imgAlumn.style.transform = "translateX(0%)"
    imgAlumn.style.visibility = "visible"
    imgTeacher.style.visibility = "hidden"
    imgTeacher.style.transform = "translateX(-110%)"
    cardTeacher.style.transform = "translateX(110%)"
    cardTeacher.style.zIndex = 1;
})

teacherBtn.addEventListener("click", () => {
    switcher.style.transform = "translateX(100%)"
    cardTeacher.style.visibility = "visible"
    cardAlumn.style.transform = "translateX(-110%)"
    cardAlumn.style.visibility = "hidden"
    cardAlumn.style.zIndex = 0;
    imgAlumn.style.transform = "translateX(110%)"
    imgAlumn.style.visibility = "hidden"
    imgTeacher.style.visibility = "visible"
    imgTeacher.style.transform = "translateX(0%)"
    cardTeacher.style.transform = "translateX(0%)"
    cardTeacher.style.zIndex = 10;
})