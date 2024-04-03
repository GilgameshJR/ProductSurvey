(function init() {
    var questionsBox=document.getElementById("questionsBox");
    document.getElementById("plus").addEventListener("click", function () {
        if (this.previousElementSibling.lastElementChild.firstElementChild.value.trim().length === 0) {
            alert("Fill the existing form before adding another one")
        } else {
            var div = document.createElement("div");
            var input = document.createElement("input");
            var button = document.createElement("button");
            button.innerHTML = "-";
            button.addEventListener("click", function () {
                questionsBox.removeChild(div);
            });
            input.setAttribute("required", "required");
            input.setAttribute("name", "q");

            div.appendChild(input);
            div.appendChild(button);

            questionsBox.appendChild(div);
        }
    })
}) ();