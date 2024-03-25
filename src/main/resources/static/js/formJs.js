$(document).ready(function () {
    $('.edit').click(function (e){
        $(".modal #staticBackdrop").modal();
        //alert('editer');
    });
});

/*
*
* // Gérer le clic sur le lien de modification
    $('a[data-action="edit"]').click(function (e) {
        e.preventDefault();
        var patientId = $(this).data('patient-id');
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8090/editPatient/' + patientId, // Endpoint pour récupérer les données du patient par son ID
            success: function (response) {
                // Remplir les champs du formulaire avec les données du patient
                $('#patientId').val(response.id);
                $('#nom').val(response.nom);
                $('#dateNaissance').val(response.dateNaissance);
                $('#malade').prop('checked', response.malade);
                $('#score').val(response.score);
            },
            error: function () {
                alert('Une erreur s\'est produite lors de la récupération des données du patient.');
            }
        });
    });
*
*
* */