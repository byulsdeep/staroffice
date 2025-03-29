function postAjaxMultipartFormData(jobCode, clientData, fn) {
    const ajax = new XMLHttpRequest()

    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {
            window[fn](ajax.responseText)
        }
    }

    const formData = new FormData()
    for (const key in clientData) formData.append(key, clientData[key])


    ajax.open('POST', jobCode)
    // ajax.setRequestHeader('Content-Type', 'multipart/form-data')
    ajax.send(formData)
}