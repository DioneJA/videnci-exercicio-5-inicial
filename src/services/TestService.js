/* eslint-disable space-before-function-paren */
import axios from 'axios'

const apiClient = axios.create({
  baseURL: 'https://videnci-exercise.herokuapp.com/api/',
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
})

export default {
  getTests(id) {
    return apiClient.get('/test/student/' + id)
  },
  postTest(test) {
    return apiClient.post('/test/', test)
  },
  deleteTest(id) {
    return apiClient.delete('/test/' + id)
  },
  getHighestScore() {
    return apiClient.get('/test/highest')
  }
}
