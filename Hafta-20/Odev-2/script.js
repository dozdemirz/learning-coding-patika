// Yeni bir liste öğesi eklemek 
function newElement() {
  var inputValue = document.getElementById("task").value;
  if (inputValue === '') {
    showToast("Listeye boş ekleme yapamazsınız!", 3000); // Boş ekleme yapıldığında toast mesajı 
    return;
  }
  var li = document.createElement("li");
  var textNode = document.createTextNode(inputValue);
  li.appendChild(textNode);
  
  // Silme düğmesi 
  var closeButton = document.createElement("span");
  closeButton.innerHTML = "&times;";
  closeButton.className = "close";
  closeButton.addEventListener("click", function() {
    this.parentElement.style.display = "none";
  });
  li.appendChild(closeButton);
  
  // Tıklama işlevi 
  li.addEventListener("click", function() {
    this.classList.toggle("completed");
  });

  document.getElementById("list").appendChild(li);
  document.getElementById("task").value = "";
}



// Local Storage'a görevleri kaydetmek
function saveToLocalStorage() {
  var listItems = document.querySelectorAll("#list li");
  var tasks = [];
  listItems.forEach(function(item) {
    tasks.push(item.textContent);
  });
  localStorage.setItem("tasks", JSON.stringify(tasks));
}

// Sayfa yüklendiğinde çalışacak
document.addEventListener("DOMContentLoaded", function() {
  var savedTasks = JSON.parse(localStorage.getItem("tasks"));
  if (savedTasks) {
    savedTasks.forEach(function(task) {
      var li = document.createElement("li");
      li.textContent = task;
      document.getElementById("list").appendChild(li);
    });
  }

  // Liste öğelerine silme düğmesi ve tıklama işlevi
  document.querySelectorAll("#list li").forEach(function(item) {
    var closeButton = document.createElement("span");
    closeButton.innerHTML = "&times;";
    closeButton.className = "close";
    closeButton.addEventListener("click", function() {
      this.parentElement.style.display = "none";
    });
    item.appendChild(closeButton);

    item.addEventListener("click", function() {
      this.classList.toggle("completed");
    });
  });
});

function showToast(message, duration) {
  var toast;
  if (message.includes("boş ekleme")) {
    toast = document.getElementById("errorToast");
  } else {
    toast = document.getElementById("successToast");
  }

  toast.classList.remove("hide");
  toast.classList.add("show");

  setTimeout(function() {
    toast.classList.remove("show");
    toast.classList.add("hide");
  }, duration);
}



