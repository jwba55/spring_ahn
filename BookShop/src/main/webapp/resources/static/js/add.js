window.addEventListener("load", e =>{
    document.getElementById("file_add").addEventListener("click", e=>{
        const ul = document.getElementById("files");
        const li = document.createElement("li");
        const input = document.createElement("input");

        input.setAttribute("type", "file");
        input.setAttribute("name", "files");
        input.setAttribute("multiple");
        input.classList.add("form-control", "form-control-sm", "mb-2");
        
        li.append(input);
        ul.append(li);

    });
});