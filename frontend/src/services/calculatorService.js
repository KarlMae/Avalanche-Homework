export function postCalculation(body) {
  return fetch(process.env.REACT_APP_BACKEND_IP + '/calculate',
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(body)
    })
    .then(data => {
      return data.json().then(data => {
        return data.result;
      })
    })
}
