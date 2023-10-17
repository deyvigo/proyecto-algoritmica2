const alumnBtn = document.querySelector(".alumnBtn")
const teacherBtn = document.querySelector(".teacherBtn")
const teacher = document.querySelector(".teacher")
const alumn = document.querySelector(".alumn")
const slider = document.querySelector(".slider")

// const color = teacherBtn.style.background


function switchAlumn(){
    slider.style.transform = "translateX(-50%)"
    teacher.style.visibility = "hidden"
    alumn.style.visibility = "visible"
    alumn.style.transform = "translateX(0%)"
    teacher.style.transform = "translateX(-100%)"
    
}

function switchTeacher(){
    slider.style.transform = "translateX(50%)"
    teacher.style.visibility = "visible"
    alumn.style.visibility = "hidden"
    teacher.style.transform = "translateX(0%)"
    alumn.style.transform = "translateX(100%)"
}

// teacherBtn.onclick =(() => {
//     teacherBtn.style.background = "black"
// })