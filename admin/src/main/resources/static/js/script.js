$(function() {
    $('.table #deleteButton').on('click',function (event) {
        event.preventDefault();
        console.log( "ready!" );
        var href=$(this).attr('href');
        console.log(href);

        $('#confirmDeleteButton').attr('href',href);
         $('#deleteModal').modal();

    });
});

// pour l'image :
$(function() {
$('.table #photoButton').on('click',function (event) {
    event.preventDefault();
    var href=$(this).attr('href');
    $('#photoModal #agentPhoto').attr('src',href);
    $('#photoModal').modal();

});
});

// pour select


// Material Select Initialization
/*$(document).ready(function() {
    $('.mdb-select').materialSelect();
});*/


var formValid = document.getElementById('envoy');
var nom = document.getElementById('nom');
var missNom = document.getElementById('missNom');
var prenom = document.getElementById('prenom');
var missPrenom = document.getElementById('missPrenom');
var cin = document.getElementById('cin');
var missCin = document.getElementById('missCin');
formValid.addEventListener('click',validation);
//var regx =/^\d{9}$/;
    function validation(event) {

      if(nom.validity.valueMissing) {
          event.preventDefault();
          missNom.textContent = 'Nom Obligatoire';
          missNom.style.color='red';
          missNom.style.fontWeight='normal';

      }



        if(prenom.validity.valueMissing) {
            event.preventDefault();
            missPrenom.textContent = 'Prenom Obligatoire';
            missPrenom.style.color='red';

        }
        if(cin.validity.valueMissing) {
            event.preventDefault();
            missCin.textContent = 'Cin Obligatoire';
            missCin.style.color='red';
            missCin.style.fontWeight='normal';

        }

      }



var nomA = document.getElementById('nomA');
var missNom = document.getElementById('missNomA');
var missAdresse = document.getElementById('missAddress');
var adresse = document.getElementById('address');
var missVille = document.getElementById('missVille');
var ville = document.getElementById('ville');
var tel = document.getElementById('tel');
var missTel = document.getElementById('missTel');
formValid.addEventListener('click',validation);
//var regx =/^\d{9}$/;
function validation(event) {

    if(nomA.validity.valueMissing) {
        event.preventDefault();
        missNom.textContent = 'Nom Obligatoire';
        missNom.style.color='red';
        missNom.style.fontWeight='normal';

    }



    if(adresse.validity.valueMissing) {
        event.preventDefault();
        missAdresse.textContent = 'Adresse Obligatoire';
        missAdresse.style.color='red';
        missAdresse.style.fontWeight='normal';

    }
    if(ville.validity.valueMissing) {
        event.preventDefault();
        missVille.textContent = 'Ville Obligatoire';
        missVille.style.color='red';
        missVille.style.fontWeight='normal';


    }

    if(tel.validity.valueMissing) {
        event.preventDefault();
        missTel.textContent = 'Tel Obligatoire';
        missTel.style.color='red';
        missTel.style.fontWeight='normal';

    }


}


/*
function checkNum()
{
    var num = document.getElementById('num');
    var message = document.getElementById('confirmeNum');
    var vert = "#06E98E";
    var rouge = "#FE0101";
    var none = "";
    var valide=/^0[1-7]\d{8}$/;

    if(valide.test(num))
    {
        num.style.backgroundColor = vert;
        message.style.color = vert;
        message.innerHTML = "Numéro Correct!";
    }

    else
    {
        num.style.backgroundColor = rouge;
        message.style.color = rouge;
        message.innerHTML = "Numéro Incorrect!";
    }

    if(num.value == "" )
    {
        num.style.backgroundColor = none;
        message.style.color = none;
        message.innerHTML = "";
    }
}*/
