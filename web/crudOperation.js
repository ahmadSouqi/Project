function setSelectedRow(pp,p) {

    if (p.className=="update"){
        pp.cells[3].setAttribute("hidden","hidden");
        pp.cells[4].removeAttribute("hidden");
        pp.cells[5].removeAttribute("hidden");
        document.getElementById("table").rows[1].cells[3].setAttribute("colspan","2");
        setRow(pp.cells,true,"9A0A2E");
    }
    if (p.className=="save"){
        var form=document.getElementById("myForm");
        document.getElementById("txtName").value=pp.cells[0].innerHTML;
        document.getElementById("txtPassword").value=pp.cells[1].innerHTML;
        document.getElementById("txtRoll").value=pp.cells[2].innerHTML;
        form.submit();
    }
    if (p.className=="cancel"){
        pp.cells[3].removeAttribute("hidden");
        pp.cells[4].setAttribute("hidden", "hidden");
        pp.cells[5].setAttribute("hidden", "hidden");
        document.getElementById("table").rows[1].cells[3].removeAttribute("colspan");
        setRow(pp.cells, false, "#47433F");
    }
}

function setRow(t,editable,color) {
    t[0].setAttribute("contenteditable",editable);
    t[1].setAttribute("contenteditable",editable);
    t[2].setAttribute("contenteditable",editable);

    t[0].style.color=color;
    t[0].style.color=color;
    t[0].style.color=color;
    t[0].style.color=color;
}

function removeRow(cell) {
    var table=document.getElementById("table");
    var i=cell.parentNode.rowIndex;
    table.deleteRow(i);
}