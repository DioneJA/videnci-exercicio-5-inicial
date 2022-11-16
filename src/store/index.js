/* eslint-disable space-before-function-paren */
import Vue, { ref } from 'vue'
import Vuex from 'vuex'
import StudentService from '../services/StudentService'
import TestService from '../services/TestService'
import { Notify } from 'quasar'

Vue.use(Vuex)

export default function (/* { ssrContext } */) {
  const Store = new Vuex.Store({
    state: {
      students: [{}],
      student: {},
      tests: [{}],
      highestScore: '',
      id: '',
      confirm: ref(false),
      dialog: ref(false),
      prompt: ref(false),
      message: ''
    },
    mutations: {
      /* ------------------------ Students ------------------------ */
      FETCH_STUDENTS(state, payload) {
        state.students = payload
      },
      DELETE_STUDENT(state, payload) {
        const result = state.students.find(obj => {
          return obj.id === payload
        })
        state.students.splice(state.students.indexOf(result), 1)

        Notify.create({
          type: 'positive',
          message: 'Aluno excluído com sucesso!'
        })
      },
      SAVE_STUDENT(state, payload) {
        state.students.push(payload)
        Notify.create({
          type: 'positive',
          message: 'Aluno adicionado com sucesso!'
        })
      },
      CONSULT_STUDENT(state, payload) {
        state.student = payload
      },
      /* ------------------------ Tests ------------------------ */
      FETCH_TESTS(state, payload) {
        state.tests = payload
      },
      DELETE_TEST(state, payload) {
        const result = state.tests.find(obj => {
          return obj.id === payload
        })
        state.tests.splice(state.tests.indexOf(result), 1)
        Notify.create({
          type: 'positive',
          message: 'Prova excluída com sucesso!'
        })
      },
      POST_TEST(state, payload) {
        state.tests.push(payload)
        Notify.create({
          type: 'positive',
          message: 'Prova adicionada com sucesso!'
        })
      },
      GET_HIGHEST_SCORE(state, payload) {
        state.highestScore = payload
      },
      SET_ID(state, payload) {
        state.id = payload
      },
      /* ------------------------ Dialogs ------------------------ */
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
      OPEN_ADD_DIALOG(state) {
        state.prompt = true
      },
      CLOSE_ADD_DIALOG(state) {
        state.prompt = false
      }
    },
    actions: {
      /* ------------------------ Students ------------------------ */
      fetchStudents({ commit }) {
        StudentService.getStudents().then(response => {
          commit('FETCH_STUDENTS', response.data)
        }).catch(error => {
          console.log('There was an error:', error.response)
        })
      },
      deleteStudent({ commit }, id) {
        StudentService.deleteStudent(id).then(() => {
          commit('DELETE_STUDENT', id)
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
          this.$router.push('/error')
        })
      },
      postStudent({ commit }, student) {
        if (student.name != null) {
          if (student.name.length >= 3) {
            StudentService.postStudent(student).then(response => {
              commit('SAVE_STUDENT', response.data)
            }).catch(error => {
              console.log('There was an error:', error.response)
              commit('OPEN_ERROR_DIALOG')
            })
          }
        }
      },
      /* ------------------------ Tests ------------------------ */
      fetchTests({ commit }, id) {
        TestService.getTests(id).then(response => {
          commit('FETCH_TESTS', response.data)
        }).catch(error => {
          console.log('There was an error:', error.response)
        })
      },
      deleteTest({ commit }, id) {
        TestService.deleteTest(id).then(response => {
          commit('DELETE_TEST', id)
        }).catch(error => {
          console.log('There was an error:', error.response)
        })
      },
      postTest({ commit }, test) {
        if (test.value !== null && test.value >= 0 && test.value <= 10) {
          TestService.postTest(test).then(response => {
            commit('POST_TEST', response.data)
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
      /* ------------------------ Dialogs ------------------------ */
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
      openAddDialog({ commit }) {
        commit('OPEN_ADD_DIALOG')
      },
      closeAddDialog({ commit }) {
        commit('CLOSE_ADD_DIALOG')
      }
    },
    modules: {
    },

    strict: process.env.DEBUGGING
  })
  return Store
}
