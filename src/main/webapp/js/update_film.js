function initDropdowns() {
    for (var j = 1970; j < 2018; j++) {
        $('#years').append(`<option>${j}</option>`);
    }

    for (var k = 1; k < 6; k++) {
        $('#raiting').append(`<option>${k}</option>`);
    }
}
$(document).ready(()=>{

    ID=getUrlParameter("id");

    $.get('/films?id='+ID, (data)=>{
        var res = data;
        tit=res.title;
        $('#title').val(res.title);
        $('#description').val(res.description);
        $('#trailer').val(res.trailerUrl);
        $('#raiting').val(res.raiting);
        $('#years').val(res.releaseDate);

        var actors = res.actors;

        var $actors = $('#actors-list');
        for(var i=0;i<actors.length;i++){
            var template=`<span class="label label-default" style="margin-bottom:5px; margin-left: 5px;">
             ${actors[i].firstName+" "+actors[i].lastName}
            </span>`;

            $actors.append(template);
        }

        var $producers = $('#producers-list');
        for(var i=0;i<res.producers.length;i++){
            var template=`<span class="label label-default" style="margin-bottom:5px; margin-left: 5px;">
             ${res.producers[i].firstName+" "+res.producers[i].lastName}
            </span>`;

            $producers.append(template);
        }

        var $genres=$('#genres-list');
        for(var i=0;i<res.genres.length;i++){
            var template=`<span class="label label-primary" style="margin-bottom:5px; margin-left: 5px;">
             ${res.genres[i].name}
            </span>`;

            $genres.append(template);
        }

        var $countries = $('#countries-list');
        for(var i=0;i<res.countries.length;i++){
            var template=`<span class="label label-success" style="margin-bottom:5px; margin-left: 5px;">
             ${res.countries[i].countryName}
            </span>`;

            $countries.append(template);
        }

    });
    
    
    initTables();
    initDropdowns();
    initDialogAdders();


    $('#add-film-button').click(()=>{
        title=$('#title').val();
        video=$('#trailer').val();
        release=$('#years').val();
        raiting=$('#raiting').val();
        description=$('#description').val();

        var result ={
            action:"UPDATE",
            id:ID,
            title: title,
            release:release,
            raiting: raiting,
            description: description,
            url:video,
            genres: JSON.stringify(genres),
            actors: JSON.stringify(actors),
            producers: JSON.stringify(producers),
            countries: JSON.stringify(countries)
        };

        $.post('/films',result,function(data){
            location.href="film.jsp?id="+data;
        });

    });

});

var actors=[];
var producers=[];
var countries=[];
var genres=[];

var  title;
var release;
var raiting;
var description;
var video;

var ID;

function initTables() {
    getAllGenres();
    getAllCountries();
    getAllPeoples();
}

function getAllGenres(){
    $.get("/genres",(data)=>{
        var genres = data.genres;
        var $table = $('.table-genres>tbody');
        $table.empty();

        genres.forEach((genre)=>{
            var tempalte = `<tr>

                <th scope="row">
                <input type="checkbox" attr-id="${genre.id}" name="checkbox-genres"
                style="margin-left:auto; margin-right:auto;">
                </th>
                <td class="genre-name-${genre.id}">${genre.name}</td>
            </tr>`;
            $table.append(tempalte);
        });
    })
}

function getAllCountries(){
    $.get("/countries",(data)=>{
        var countries = data.countries;
        var $table = $('.table-countries>tbody');
        $table.empty();

        countries.forEach((country)=>{
            var tempalte = `<tr>
                <th scope="row">
                <input attr-id="${country.id}" type="checkbox" name="checkbox-countries" value="checked"
                style="margin-left:auto; margin-right:auto;">
                </th>
                <td class="country-name-${country.id}">${country.countryName}</td>
            </tr>`;
            $table.append(tempalte);
        });



    })


}

function getAllPeoples(){
    $.get("/peoples",(data)=>{
        var chbActor="checkbox-actor";
        var chbProd="checkbox-producer";
        var countries = data.peoples;
        var $tableActors = $('.table-actors>tbody');
        $tableActors.empty();
        var $tableProducers = $('.table-producers>tbody');
        $tableProducers.empty();

        countries.forEach((people)=>{
            var tempalte1 = `<tr>
                <th scope="row">
                <input   attr-id="${people.id}" type="checkbox" name="${chbActor}"
                                       style="margin-left:auto; margin-right:auto;">
                </th>
                <td class="actor-name-${people.id}">${people.firstName}</td>
                <td class="actor-lastname-${people.id}">${people.lastName}</td>
            </tr>`;
            $tableActors.append(tempalte1);

            var tempalte2 = `<tr>
                <th scope="row">
                <input attr-id="${people.id}" type="checkbox" name="${chbProd}"
                                       style="margin-left:auto; margin-right:auto;">
                </th>
                <td class="producer-name-${people.id}">${people.firstName}</td>
                <td class="producer-lastname-${people.id}">${people.lastName}</td>
            </tr>`;
            $tableProducers.append(tempalte2);
        });

    })

}

function initDialogAdders() {
    $('#add-actors-dialog-btn').click(()=> {
        var checked = $("input[name=checkbox-actor]:checked");
        var $actorList = $("#actors-list");
        $actorList.empty();
        for (var i = 0; i < checked.length; i++) {

            var ID = $(checked[i]).attr("attr-id");
            var firstName = $(".actor-name-" + ID).text();
            var lastName = $(".actor-lastname-" + ID).text();
            var template = `  <span class="label label-default" style="margin-bottom:5px;">${firstName + " " + lastName}</span>`;
            actors.push(ID);
            $actorList.append(template);
            $("#modal-actors").modal('hide');
        }
    });

    $('#add-producers-dialog-btn').click(()=> {
        var checked = $("input[name=checkbox-producer]:checked");
        var $producerList = $("#producers-list");
        $producerList.empty();
        for (var i = 0; i < checked.length; i++) {

            var ID = $(checked[i]).attr("attr-id");
            var firstName = $(".producer-name-" + ID).text();
            var lastName = $(".producer-lastname-" + ID).text();
            var template = `  <span class="label label-default" style="margin-bottom:5px;">${firstName + " " + lastName}</span>`;
            producers.push(ID);
            $producerList.append(template);
            $("#modal-producers").modal('hide');
        }
    });

    $('#add-genres-dialog-btn').click(()=> {
        var checked = $("input[name=checkbox-genres]:checked");
        var $genresList = $("#genres-list");
        $genresList.empty();
        for (var i = 0; i < checked.length; i++) {

            var ID = $(checked[i]).attr("attr-id");
            var genre = $(".genre-name-" + ID).text();
            var template = `  <span class="label label-default" style="margin-bottom:5px;">${genre}</span>`;
            genres.push(ID);
            $genresList.append(template);
            $("#modal-genres").modal('hide');
        }
    });

    $('#add-countries-dialog-btn').click(()=> {
        var checked = $("input[name=checkbox-countries]:checked");
        var $countriesList = $("#countries-list");
        $countriesList.empty();
        for (var i = 0; i < checked.length; i++) {

            var ID = $(checked[i]).attr("attr-id");
            var country = $(".country-name-" + ID).text();
            var template = `  <span class="label label-default" style="margin-bottom:5px;">${country}</span>`;
            countries.push(ID);
            $countriesList.append(template);
            $("#modal-countries").modal('hide');
        }
    });
}

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
