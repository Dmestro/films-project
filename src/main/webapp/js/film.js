$(document).ready(()=>{
    ID=getUrlParameter("id");
    $.get('/films?id='+ID, (data)=>{
        var res = data;
        tit=res.title;
        $('#title').html(`<h1 style="margin-top: 268px;">${res.title}</h1>
          <h4>${res.releaseDate} год</h4>
          <h5>Оценка ${res.raiting}/5</h5>
          `);
        $('#description>.panel-body').html(res.description);
         $('#video').append(`<iframe width="100%" height="50%" src="${res.trailerUrl}" frameborder="0" allowfullscreen></iframe>`);

        var actors = res.actors;

        var $actors = $('#actors>.panel-body');
        for(var i=0;i<actors.length;i++){
            var template=`<span class="label label-default" style="margin-bottom:5px; margin-left: 5px;">
             ${actors[i].firstName+" "+actors[i].lastName}
            </span>`;

            $actors.append(template);
        }

        var $producers = $('#producers>.panel-body');
        for(var i=0;i<res.producers.length;i++){
            var template=`<span class="label label-default" style="margin-bottom:5px; margin-left: 5px;">
             ${res.producers[i].firstName+" "+res.producers[i].lastName}
            </span>`;

            $producers.append(template);
        }

        var $genres=$('#genres>.panel-body');
        for(var i=0;i<res.genres.length;i++){
            var template=`<span class="label label-primary" style="margin-bottom:5px; margin-left: 5px;">
             ${res.genres[i].name}
            </span>`;

            $genres.append(template);
        }

        var $countries = $('#countries>.panel-body');
        for(var i=0;i<res.countries.length;i++){
            var template=`<span class="label label-success" style="margin-bottom:5px; margin-left: 5px;">
             ${res.countries[i].countryName}
            </span>`;

            $countries.append(template);
        }

    });
    $('#cancel-add-button').click(()=>{

        var isDelete = confirm("Вы действительно хотите удалить фильм '"+tit+"'?")

        if(isDelete){
            $.post('/films',{id:ID, action:"DELETE"},()=>{
                location.href="index.jsp";
            });
        }

    });
    
    $('#add-dialog-button').click(()=>{
        location.href="update_film.jsp?id="+ID;
    });
});

var ID;
var tit;

function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};