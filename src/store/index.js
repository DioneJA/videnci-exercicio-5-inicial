/* eslint-disable space-before-function-paren */
import Vue, { ref } from 'vue'
import Vuex from 'vuex'
import StudentService from '../services/StudentService'
import TestService from '../services/TestService'

Vue.use(Vuex)

/*
 * If not building with SSR mode, you can
 * directly export the Store instantiation;
 *
 * The function below can be async too; either use
 * async/await or return a Promise which resolves
 * with the Store instance.
 */

export default function (/* { ssrContext } */) {
  const Store = new Vuex.Store({
    state: {
      students: [{}],
      student: {},
      tests: [{}],
      highestScore: '',
      confirm: ref(false),
      dialog: ref(false),
      prompt: ref(false),
      message: '',
      id: ''
    },
    getters: {
    },
    mutations: {
      FETCH_STUDENTS(state, payload) {
        state.students = payload
      },
      DELETE_STUDENT(state) {
      },
      SAVE_STUDENT(state, payload) {
      },
      CONSULT_STUDENT(state, payload) {
        state.student = payload
      },
      FETCH_TESTS(state, payload) {
        state.tests = payload
      },
      DELETE_TEST(state) {
      },
      POST_TEST(state) {
      },
      GET_HIGHEST_SCORE(state, payload) {
        state.highestScore = payload
      },
      SET_ID(state, payload) {
        state.id = payload
      },
      OPEN_CONFIRM_DIALOG(state, payload) {
        state.confirm = payload.boolean
        state.message = payload.msg
        state.id = payload.id
      },
      CLOSE_CONFIRM_DIALOG(state, payload) {
        state.confirm = payload
      },
      OPEN_ERROR_DIALOG(state) {
        state.dialog = true
      },
      CLOSE_ERROR_DIALOG(state, payload) {
        state.dialog = payload
      },
      OPEN_ADD_DIALOG(state, payload) {
        state.prompt = true
        state.student = payload
      },
      CLOSE_ADD_DIALOG(state) {
        state.prompt = false
      }
    },
    actions: {
      fetchStudents({ commit }) {
        StudentService.getStudents().then(response => {
          commit('FETCH_STUDENTS', response.data)
        }).catch(error => {
          console.log('There was an error:', error.response)
        })
      },
      deleteStudent({ commit }, id) {
        StudentService.deleteStudent(id).then(response => {
          commit('DELETE_STUDENT')
          window.location.reload(true)
          console.log(response)
        }).catch(error => {
          console.log('There was an error:', error.response)
          commit('OPEN_ERROR_DIALOG')
        })
      },
      consultStudent({ commit }, id) {
        StudentService.getStudent(id).then(response => {
          commit('CONSULT_STUDENT', response.data)
        }).catch(error => {
          console.log('There was an error:', error.response)
        })
      },
      postStudent({ commit }, student) {
        if (student.name != null) {
          if (student.name.length >= 3) {
            StudentService.postStudent(student).then(response => {
              commit('SAVE_STUDENT')
              window.location.reload(true)
            }).catch(error => {
              console.log('There was an error:', error.response)
              commit('OPEN_ERROR_DIALOG')
            })
          }
        }
      },
      fetchTests({ commit }, id) {
        TestService.getTests(id).then(response => {
          commit('FETCH_TESTS', response.data)
        }).catch(error => {
          console.log('There was an error:', error.response)
        })
      },
      deleteTest({ commit }, id) {
        TestService.deleteTest(id).then(response => {
          commit('DELETE_TEST')
          window.location.reload(true)
        }).catch(error => {
          console.log('There was an error:', error.response)
        })
      },
      postTest({ commit }, test) {
        if (test.value !== null && test.value >= 0 && test.value <= 10) {
          TestService.postTest(test).then(response => {
            commit('POST_TEST')
            window.location.reload(true)
          }).catch(error => {
            console.log('There was an error:', error.response)
          })
        }
      },
      getHighestScore() {
        TestService.getHighestScore().then(response => {
          this.commit('GET_HIGHEST_SCORE', response.data)
        }).catch(error => {
          console.log('There was an error:', error.response)
        })
      },
      setStudentID({ commit }, id) {
        commit('SET_ID', id)
      },
      openConfirmDialog({ commit }, value) {
        commit('OPEN_CONFIRM_DIALOG', value)
      },
      closeConfirmDialog({ commit }) {
        commit('CLOSE_CONFIRM_DIALOG', false)
      },
      closeErrorDialog({ commit }) {
        commit('CLOSE_ERROR_DIALOG', false)
      },
      openAddDialog({ commit }, student) {
        commit('OPEN_ADD_DIALOG', student)
      },
      closeAddDialog({ commit }) {
        commit('CLOSE_ADD_DIALOG')
      }
    },
    modules: {
    },

    // enable strict mode (adds overhead!)
    // for dev mode only
    strict: process.env.DEBUGGING
  })
  return Store
}
