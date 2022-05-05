// const speed = prompt();
// const size = prompt();

document.getElementById("inner-orbit").style.animation = "spin-right " + "0" +"s linear infinite"

let innerOrbitWidth = getComputedStyle(document.getElementById("inner-orbit")).width
console.log(innerOrbitWidth)
console.log(document.querySelector(".inner-orbit-circles"))
document.querySelector(".inner-orbit-circles").style.top = (Math.sqrt(0,5 * ((Math.sqrt(2)* innerOrbitWidth) - innerOrbitWidth) * 0,5) + "px")
console.log(Math.sqrt(0,5 * ((Math.sqrt(2)* innerOrbitWidth) - innerOrbitWidth) * 0,5))
document.querySelector(".inner-orbit-circles").style.left = (Math.sqrt(0,5 * ((Math.sqrt(2)* innerOrbitWidth) - innerOrbitWidth) * 0,5) + "px")