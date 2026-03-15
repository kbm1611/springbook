const deleteButton = document.getElementById('delete-btn');

if(deleteButton){
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
        .then(() => {
            alert('삭제가 완료되었습니다.');
            location.replace('/articles');
        });
    });
}

const modifyButton = document.getElementById('modify-btn');

if(modifyButton){
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
        .then(() => {
            alert('수정이 완료되었습니다.');
            location.replace(`/articles/${id}`);
        });
    });
}

const createButton = document.getElementById('create-btn');

if(createButton){
    createButton.addEventListener('click', event => {
        fetch(`/api/articles`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
        .then(() => {
            alert('등록이 완료되었습니다.');
            location.replace('/articles');
        });
    });
}
//-----------------------------댓글 기능(등록, 삭제)-----------------------------

const replyCreateButton = document.getElementById('replycreate-btn');

if(replyCreateButton){
    replyCreateButton.addEventListener('click', event => {
        const aid = document.getElementById('article-id').value;
        const content = prompt("댓글 내용을 입력하세요:");

        if (content === null || content.trim() === "") {
            return;
        }

        fetch(`/api/replies`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                aid: aid,
                content: content
            })
        })
        .then(() => {
            alert('등록이 완료되었습니다.');
            location.reload();
        });
    });
}

const replyDelButtons = document.querySelectorAll('.reply-del-btn');

replyDelButtons.forEach(button => {
    button.addEventListener('click', event => {
        const id = event.currentTarget.dataset.id;

        fetch(`/api/replies/${id}`, {
            method: 'DELETE'
        })
        .then(() => {
            alert('삭제가 완료되었습니다.');
            location.reload();
        });
    });
});

