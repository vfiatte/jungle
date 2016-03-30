/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function onload(){
    $('.contenu').load('accueilContenu');
    $('.menu').load('menu');
    $('.footer').load('pied');
}

function listerParties(){
    $('.contenu').load('Partie/creer')
}

function ajoutJoueur(){
    $('.contenu').load('Joueur/ajout')
}

function rejoindre(id){
    $('.contenu').load('Partie/rejoindre/'+id);
}

function rejoindrePost(){
    $.post(('/jquery/Partie/rejoindre'), $('form').serialize(), function success(data) {
        $('.contenu').html(data);
    });
}
