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
  getStudents() {
    return apiClient.get('/student')
  },
  getStudent(id) {
    return apiClient.get('/student/' + id)
  },
  postStudent(student) {
    return apiClient.post('/student/', student)
  },
  deleteStudent(id) {
    return apiClient.delete('/student/' + id)
  }
}
