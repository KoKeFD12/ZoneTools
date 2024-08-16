function deleteMovementById(id) {
    fetch('movements/delete/' + id, {method: "DELETE"});
}