/**
 * Created by Lytki on 15.04.2017.
 */
/**
 * Created by Lytki on 14.04.2017.
 */
$(document).ready(()=>{
    getAllGenres();
    activateDialogButtons();
});
var actionFlag;
var ID;
var GENRE_NAME;
var ASAS;
function getAllGenres(){
    $.get("/genres",(data)=>{
        var genres = data.genres;
        var $table = $('.table-genres>tbody');
        $table.empty();

        genres.forEach((genre)=>{
            var tempalte = `<tr>
                <th class="genre-id-${genre.id}"scope="row">${genre.id}</th>
                <td class="genre-name-${genre.id}">${genre.name}</td>
                <td><a class="changer"><i id-attr="${genre.id}" class="glyphicon glyphicon-pencil"></i></a>
                    <a class="remover" "><i id-attr="${genre.id}" class="glyphicon glyphicon-remove"></i></a></td>
            </tr>`;
            $table.append(tempalte);
        });

        var $countryChangers = $('.changer');

        for(var i=0;i<$countryChangers.length;i++){
            $countryChangers[i].onclick=(event)=>{
                console.log(event.target);
                console.log($(event.target));
                ID=$(event.target).attr('id-attr');
                GENRE_NAME = $('.genre-name-'+ID).text();
                var $opacifier = $('.opacifier');
                var $addCountryDialog = $('.add-dialog');
                $opacifier.show();
                $addCountryDialog.show();
                $('#genre-name').val(GENRE_NAME);
                actionFlag="UPDATE";
            };
        }

        var $countryRemovers = $('.remover');
        for(var i=0;i<$countryRemovers.length;i++){
            $countryRemovers[i].onclick=(event)=>{
                console.log(event.target);
                console.log($(event.target));
                ID=$(event.target).attr('id-attr');
                $.post('/genres',{action:"DELETE",id:ID},function(){getAllGenres();
                });

            };
        }



    })


}
function activateDialogButtons(){
    $('#add-dialog-button').click(()=>{
        var $opacifier = $('.opacifier');
        var $addCountryDialog = $('.add-dialog');
        $('#genre-name').val("");
        $opacifier.show();
        $addCountryDialog.show();
        $('#genre-name').focus();

        actionFlag="ADD";
    });
    $('#cancel-add-button').click(()=>{
        var $opacifier = $('.opacifier');
        var $addCountryDialog = $('.add-dialog');
        $opacifier.hide();
        $addCountryDialog.hide();
    });

    $('#add-button').click(()=>{
        if(actionFlag==="ADD"){
            var genre=$('#genre-name').val();
            console.log(genre);
            $.post('/genres',{action:actionFlag,genreName:genre},function(){getAllGenres();});
            var $opacifier = $('.opacifier');
            var $addCountryDialog = $('.add-dialog');
            $opacifier.hide();
            $addCountryDialog.hide();

        }

        if(actionFlag==="UPDATE"){
            $.post('/genres',{action:actionFlag,genre:{id:ID,name:$('#genre-name').val()}},function(){getAllGenres();});
            var $opacifier = $('.opacifier');
            var $addCountryDialog = $('.add-dialog');
            $opacifier.hide();
            $addCountryDialog.hide();

        }
    });



}