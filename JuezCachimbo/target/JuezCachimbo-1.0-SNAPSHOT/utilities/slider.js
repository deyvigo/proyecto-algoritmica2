const alumnBtn = document.querySelector(".alumnBtn")
const teacherBtn = document.querySelector(".teacherBtn")
const teacher = document.querySelector(".teacher")
const alumn = document.querySelector(".alumn")
const slider = document.querySelector(".slider")
const imgTeacher = document.querySelector(".imgTeacher")
const imgAlumn = document.querySelector(".imgAlumn")

// const color = teacherBtn.style.background


function switchAlumn(){
    slider.style.transform = "translateX(-50%)"
    teacher.style.visibility = "hidden"
    alumn.style.visibility = "visible"
    alumn.style.transform = "translateX(0%)"
    teacher.style.transform = "translateX(-110%)"
    imgAlumn.style.transform = "translateX(0%)"
    imgTeacher.style.transform = "translateX(110%)"
    imgTeacher.style.visibility = "hidden"
    imgAlumn.style.visibility = "visible"
}

function switchTeacher(){
    slider.style.transform = "translateX(50%)"
    teacher.style.visibility = "visible"
    alumn.style.visibility = "hidden"
    teacher.style.transform = "translateX(0%)"
    alumn.style.transform = "translateX(110%)"
    imgTeacher.style.transform = "translateX(0%)"
    imgAlumn.style.transform = "translateX(-110%)"
    imgTeacher.style.visibility = "visible"
    imgAlumn.style.visibility = "hidden"
}

// teacherBtn.onclick =(() => {
//     teacherBtn.style.background = "black"
// })