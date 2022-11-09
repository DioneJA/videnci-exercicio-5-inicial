import axios from 'axios'

export default ({ Vue }) => {
  Vue.prototype.$axios = axios.create({
    baseURL: 'https://videnci-exercise.herokuapp.com/api/'
  })
}
